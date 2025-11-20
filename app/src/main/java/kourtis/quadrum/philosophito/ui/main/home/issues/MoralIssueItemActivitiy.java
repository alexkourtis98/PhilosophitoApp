package kourtis.quadrum.philosophito.ui.main.home.issues;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.billthefarmer.markdown.MarkdownView;

import java.lang.ref.WeakReference;

import kourtis.quadrum.philosophito.MainActivity;
import kourtis.quadrum.philosophito.core.util.AppConstants;
import kourtis.quadrum.philosophito.core.util.IntentKeys;
import kourtis.quadrum.philosophito.databinding.ActivityMoralIssuesItemBinding;
import kourtis.quadrum.philosophito.ui.main.data.FavoriteItem;
import kourtis.quadrum.philosophito.ui.main.data.Issue;
import kourtis.quadrum.philosophito.ui.main.general.AboutActivitiy;

/**
 * Activity for displaying detailed information about a moral issue.
 * Shows markdown content and allows users to bookmark/favorite the issue.
 *
 * <p>Receives the following Intent extras:
 * <ul>
 *   <li>{@link IntentKeys#EXTRA_TITLE} - Issue title</li>
 *   <li>{@link IntentKeys#EXTRA_MD_LOCATION} - Markdown file path</li>
 *   <li>{@link IntentKeys#EXTRA_ENUM_TYPE} - Issue type enum</li>
 *   <li>{@link IntentKeys#EXTRA_AUDIO_LOCATION} - Audio file path (optional)</li>
 * </ul>
 *
 * @version 2.0
 * @see MoralIssuesFragment
 * @see Issue
 */
public class MoralIssueItemActivitiy extends AppCompatActivity {

    // Instance variables (not static to avoid memory leaks)
    private MediaPlayer mMediaPlayer;
    private final Issue moralIssue = new Issue();
    private ImageView play;
    private SeekBar mSeekBarTime;
    private SeekBarHandler handler;
    private ActivityMoralIssuesItemBinding binding;

    /**
     * Static inner Handler class to prevent memory leaks.
     * Uses WeakReference to avoid holding strong reference to Activity.
     */
    private static class SeekBarHandler extends Handler {
        private final WeakReference<MoralIssueItemActivitiy> activityRef;

        SeekBarHandler(MoralIssueItemActivitiy activity) {
            super(Looper.getMainLooper());
            this.activityRef = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            MoralIssueItemActivitiy activity = activityRef.get();
            if (activity != null && activity.mSeekBarTime != null) {
                activity.mSeekBarTime.setProgress(msg.what);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMoralIssuesItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        handler = new SeekBarHandler(this);
        setUpUI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Clean up Handler to prevent memory leaks
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }

        // Release MediaPlayer resources
        releaseMediaPlayer();
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
     * Builds a FavoriteItem from the current issue
     */
    private FavoriteItem buildFavoriteItem() {
        FavoriteItem favoriteItem = new FavoriteItem();
        favoriteItem.setTitle(this.moralIssue.getTitle());
        favoriteItem.setMdFile(this.moralIssue.getMdLocation());
        favoriteItem.setEnumtype(this.moralIssue.getEnumtype());
        favoriteItem.setAudiofile(this.moralIssue.getAudioLocation());
        return favoriteItem;
    }

    /**
     * Saves the current issue to favorites using SharedPreferences
     */
    private void saveItem() {
        SharedPreferences prefs = getSharedPreferences(
                AppConstants.PREFS_NAME,
                Context.MODE_PRIVATE
        );
        FavoriteItem favoriteItem = buildFavoriteItem();
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(favoriteItem);
        editor.putString(favoriteItem.getEnumtype(), json);
        editor.apply();
    }

    /**
     * Removes the current issue from favorites
     */
    private void removeItem() {
        SharedPreferences prefs = getSharedPreferences(
                AppConstants.PREFS_NAME,
                Context.MODE_PRIVATE
        );
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(this.moralIssue.getEnumtype());
        editor.apply();
    }

    /**
     * Bookmarks the current issue and updates UI
     */
    private void bookMark() {
        saveItem();
        changeIconToBooked();
    }

    /**
     * Removes bookmark from current issue and updates UI
     */
    private void bookUnmark() {
        removeItem();
        changeIconToUnbooked();
    }

    /**
     * Updates UI to show issue is bookmarked
     */
    private void changeIconToBooked() {
        binding.bookmark.setVisibility(View.GONE);
        binding.bookmarkUnmark.setVisibility(View.VISIBLE);
    }

    /**
     * Updates UI to show issue is not bookmarked
     */
    private void changeIconToUnbooked() {
        binding.bookmark.setVisibility(View.VISIBLE);
        binding.bookmarkUnmark.setVisibility(View.GONE);
    }

    /**
     * Sets up bookmark button click listeners
     */
    private void setBookMarkListeners() {
        binding.bookmark.setOnClickListener(click -> {
            bookMark();
            Toast.makeText(this, "Saved to Favorites", Toast.LENGTH_SHORT).show();
        });

        binding.bookmarkUnmark.setOnClickListener(click -> bookUnmark());
    }

    /**
     * Checks if current issue is already bookmarked and updates UI accordingly
     */
    private void checkIfBooked() {
        SharedPreferences prefs = getSharedPreferences(
                AppConstants.PREFS_NAME,
                Context.MODE_PRIVATE
        );
        if (prefs.getAll().containsKey(this.moralIssue.getEnumtype())) {
            changeIconToBooked(); // Don't call bookMark() to avoid duplicate save
        } else {
            changeIconToUnbooked();
        }
    }

    /**
     * Initializes bookmark functionality
     */
    private void bookStuff() {
        setBookMarkListeners();
        checkIfBooked();
    }

    /**
     * Extracts issue data from Intent extras
     */
    private void setMoralIssue() {
        Intent intent = getIntent();
        this.moralIssue.setTitle(intent.getStringExtra(IntentKeys.EXTRA_TITLE));
        this.moralIssue.setMdLocation(intent.getStringExtra(IntentKeys.EXTRA_MD_LOCATION));
        this.moralIssue.setAudioLocation(intent.getStringExtra(IntentKeys.EXTRA_AUDIO_LOCATION));
        this.moralIssue.setEnumtype(intent.getStringExtra(IntentKeys.EXTRA_ENUM_TYPE));
    }

    /**
     * Loads markdown content into the view
     */
    private void setMD() {
        MarkdownView markdownView = binding.content;
        if (markdownView != null && this.moralIssue.getMdLocation() != null) {
            markdownView.loadMarkdownFile(
                    "file:///android_asset/",
                    this.moralIssue.getMdLocation(),
                    "file:///android_asset/style.css"
            );
        }
    }

    /**
     * Sets the issue title in the UI
     */
    private void setupTitle() {
        TextView titleView = binding.moraltitle;
        if (titleView != null && this.moralIssue.getTitle() != null) {
            titleView.setText(this.moralIssue.getTitle());
        }
    }

    /**
     * Sets up the main UI components
     */
    private void setUpUI() {
        setMoralIssue();
        setMD();
        setMenuButtons();
        setupTitle();
        bookStuff();
    }

    /**
     * Sets up navigation button click listeners
     */
    private void setMenuButtons() {
        binding.infoBtn.setOnClickListener(click -> {
            Intent intent = new Intent(this, AboutActivitiy.class);
            startActivity(intent);
        });

        binding.logoimg.setOnClickListener(click -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}
