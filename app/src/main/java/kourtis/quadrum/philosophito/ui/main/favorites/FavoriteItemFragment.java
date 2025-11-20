package kourtis.quadrum.philosophito.ui.main.favorites;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import org.billthefarmer.markdown.MarkdownView;

import java.lang.ref.WeakReference;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.core.util.AppConstants;
import kourtis.quadrum.philosophito.core.util.IntentKeys;
import kourtis.quadrum.philosophito.databinding.FragmentFavoriteitemBinding;
import kourtis.quadrum.philosophito.ui.main.data.FavoriteItem;

/**
 * Fragment for displaying detailed information about a favorited item.
 * Shows content for both dictionary terms and moral theories/issues.
 *
 * <p>Receives the following Bundle arguments:
 * <ul>
 *   <li>{@link IntentKeys#EXTRA_TITLE} - Item title</li>
 *   <li>{@link IntentKeys#EXTRA_ENUM_TYPE} - Item type enum</li>
 *   <li>For dictionary terms:
 *     <ul>
 *       <li>{@link IntentKeys#EXTRA_DESCRIPTION} - Term definition</li>
 *       <li>{@link IntentKeys#EXTRA_SOURCE_URL} - Source URL</li>
 *     </ul>
 *   </li>
 *   <li>For theories/issues:
 *     <ul>
 *       <li>{@link IntentKeys#EXTRA_MD_LOCATION} - Markdown file path</li>
 *       <li>{@link IntentKeys#EXTRA_AUDIO_LOCATION} - Audio file path (optional)</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * @version 2.0
 * @see FavoritesFragment
 * @see FavoriteItem
 */
public class FavoriteItemFragment extends Fragment {

    // Instance variables (not static to avoid memory leaks)
    private MediaPlayer mMediaPlayer;
    private final FavoriteItem favoriteItem = new FavoriteItem();
    private ImageView play;
    private SeekBar mSeekBarTime;
    private SeekBarHandler handler;
    private FragmentFavoriteitemBinding binding;
    private ViewGroup container;

    /**
     * Static inner Handler class to prevent memory leaks.
     * Uses WeakReference to avoid holding strong reference to Fragment.
     */
    private static class SeekBarHandler extends Handler {
        private final WeakReference<FavoriteItemFragment> fragmentRef;

        SeekBarHandler(FavoriteItemFragment fragment) {
            super(Looper.getMainLooper());
            this.fragmentRef = new WeakReference<>(fragment);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            FavoriteItemFragment fragment = fragmentRef.get();
            if (fragment != null && fragment.mSeekBarTime != null) {
                fragment.mSeekBarTime.setProgress(msg.what);
            }
        }
    }

    public FavoriteItemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new SeekBarHandler(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoriteitemBinding.inflate(inflater, container, false);
        this.container = container;

        setListeners();
        setOnBackPressed();
        configureTypeOfView();
        checkIfBooked();

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // Clean up Handler to prevent memory leaks
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }

        // Release MediaPlayer resources
        releaseMediaPlayer();

        // Clear binding reference
        binding = null;
    }

    /**
     * Properly releases MediaPlayer resources to prevent memory leaks
     */
    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.stop();
            }
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    /**
     * Updates UI to show item is bookmarked
     */
    private void changeIconToBooked() {
        if (binding != null) {
            binding.bookmarkUnmark.setVisibility(View.VISIBLE);
            binding.moralbookmarkUnmark.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Updates UI to show item is not bookmarked
     */
    private void changeIconToUnbooked() {
        if (binding != null) {
            binding.bookmarkUnmark.setVisibility(View.GONE);
            binding.moralbookmarkUnmark.setVisibility(View.GONE);
        }
    }

    /**
     * Removes the current item from favorites
     */
    private void removeItem() {
        SharedPreferences prefs = requireContext().getSharedPreferences(
                AppConstants.PREFS_NAME,
                Context.MODE_PRIVATE
        );
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(this.favoriteItem.getEnumtype());
        editor.apply();
    }

    /**
     * Removes bookmark from current item and updates UI
     */
    private void bookUnmark() {
        removeItem();
        changeIconToUnbooked();
    }

    /**
     * Checks if current item is already bookmarked and updates UI accordingly
     */
    private void checkIfBooked() {
        SharedPreferences prefs = requireContext().getSharedPreferences(
                AppConstants.PREFS_NAME,
                Context.MODE_PRIVATE
        );
        if (prefs.getAll().containsKey(this.favoriteItem.getEnumtype())) {
            changeIconToBooked();
        } else {
            changeIconToUnbooked();
        }
    }

    /**
     * Sets up back press handling to navigate to FavoritesFragment
     */
    private void setOnBackPressed() {
        ViewGroup mycontainer = this.container;
        requireActivity().getOnBackPressedDispatcher().addCallback(
                getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        if (mycontainer != null && mycontainer.getContext() instanceof AppCompatActivity) {
                            ((AppCompatActivity) mycontainer.getContext())
                                    .getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.frame, new FavoritesFragment())
                                    .commit();
                        }
                    }
                }
        );
    }

    /**
     * Sets up click listeners for bookmark buttons
     */
    private void setListeners() {
        if (binding != null) {
            binding.bookmarkUnmark.setOnClickListener(click -> bookUnmark());
            binding.moralbookmarkUnmark.setOnClickListener(click -> bookUnmark());
        }
    }

    /**
     * Opens external link in browser
     */
    private void openLink(View view) {
        if (this.favoriteItem.getSource() != null) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(this.favoriteItem.getSource()));
            view.getContext().startActivity(intent);
        }
    }

    /**
     * Displays dictionary term content in UI
     */
    private void showTermTexts() {
        if (binding != null) {
            binding.title.setText(this.favoriteItem.getTitle());
            binding.definition.setText(this.favoriteItem.getTextcontent());
            binding.source.setOnClickListener(this::openLink);
        }
    }

    /**
     * Displays moral theory/issue content in UI
     */
    private void showMoralContent() {
        if (binding != null) {
            binding.moraltitle.setText(this.favoriteItem.getTitle());
            MarkdownView markdownView = binding.content;
            if (markdownView != null && this.favoriteItem.getMdFile() != null) {
                markdownView.loadMarkdownFile(
                        "file:///android_asset/",
                        this.favoriteItem.getMdFile(),
                        "file:///android_asset/style.css"
                );
            }
        }
    }

    /**
     * Extracts dictionary term data from Bundle arguments
     */
    private void setUpFavoriteItemTerm() {
        Bundle args = getArguments();
        if (args != null) {
            this.favoriteItem.setTitle(args.getString(IntentKeys.EXTRA_TITLE));
            this.favoriteItem.setEnumtype(args.getString(IntentKeys.EXTRA_ENUM_TYPE));
            this.favoriteItem.setTextcontent(args.getString(IntentKeys.EXTRA_DESCRIPTION));
            this.favoriteItem.setSource(args.getString(IntentKeys.EXTRA_SOURCE_URL));
        }
    }

    /**
     * Extracts moral theory/issue data from Bundle arguments
     */
    private void setUpFavoriteItemMoral() {
        Bundle args = getArguments();
        if (args != null) {
            this.favoriteItem.setAudiofile(args.getString(IntentKeys.EXTRA_AUDIO_LOCATION));
            this.favoriteItem.setTitle(args.getString(IntentKeys.EXTRA_TITLE));
            this.favoriteItem.setEnumtype(args.getString(IntentKeys.EXTRA_ENUM_TYPE));
            this.favoriteItem.setMdFile(args.getString(IntentKeys.EXTRA_MD_LOCATION));
        }
    }

    /**
     * Configures UI to display dictionary term
     */
    private void setUpDictionaryTermView() {
        if (binding != null) {
            binding.termlayout.setVisibility(View.VISIBLE);
            binding.morallayout.setVisibility(View.GONE);
            setUpFavoriteItemTerm();
            showTermTexts();
        }
    }

    /**
     * Configures UI to display moral theory or issue
     */
    private void setUpDictionaryMoralTheoryOrMoralIssueView() {
        if (binding != null) {
            binding.morallayout.setVisibility(View.VISIBLE);
            binding.termlayout.setVisibility(View.GONE);
            setUpFavoriteItemMoral();
            showMoralContent();
        }
    }

    /**
     * Determines type of content and configures view accordingly
     */
    private void configureTypeOfView() {
        Bundle args = getArguments();
        if (args != null) {
            String mdLocation = args.getString(IntentKeys.EXTRA_MD_LOCATION, "");
            boolean isTerm = mdLocation.trim().isEmpty();
            if (isTerm) {
                setUpDictionaryTermView();
            } else {
                setUpDictionaryMoralTheoryOrMoralIssueView();
            }
        }
    }
}
