package kourtis.quadrum.philosophito.ui.main.favorites;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
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

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.databinding.FragmentFavoriteitemBinding;
import kourtis.quadrum.philosophito.ui.main.data.FavoriteItem;

public class FavoriteItemFragment extends Fragment {
    static MediaPlayer mMediaPlayer;
    private final FavoriteItem favoriteItem = new FavoriteItem();
    ImageView play;
    SeekBar mSeekBarTime;
    @SuppressLint({"Handler Leak", "HandlerLeak"})
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mSeekBarTime.setProgress(msg.what);
        }
    };
    private FragmentFavoriteitemBinding binding;
    private ViewGroup container;

    public FavoriteItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void changeIconToBooked() {
        binding.bookmarkUnmark.setVisibility(View.VISIBLE);
        binding.moralbookmarkUnmark.setVisibility(View.VISIBLE);
    }

    private void changeIconToUnbooked() {
        binding.bookmarkUnmark.setVisibility(View.GONE);
        binding.moralbookmarkUnmark.setVisibility(View.GONE);

//        View view = binding.seekBarTime;
//        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//        layoutParams.width = RelativeLayout.LayoutParams.MATCH_PARENT;
//        view.setLayoutParams(layoutParams);
    }

    private void removeItem() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(requireContext());
        SharedPreferences.Editor refsEditor = prefs.edit();
        refsEditor.remove(this.favoriteItem.getEnumtype());
        refsEditor.apply();
    }

    private void bookUnmark() {
        removeItem();
        changeIconToUnbooked();
    }

    private void checkIfBooked() {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(requireContext());

        if (mPrefs.getAll().containsKey(this.favoriteItem.getEnumtype())) {
            changeIconToBooked();
        } else {
            bookUnmark();
        }
    }

    private void setOnBackPressed() {
        ViewGroup mycontainer = this.container;
        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                ((AppCompatActivity) mycontainer.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new FavoritesFragment()).commit();
            }
        });
    }

    private void setListeners() {
        binding.bookmarkUnmark.setOnClickListener(click -> bookUnmark());
        binding.moralbookmarkUnmark.setOnClickListener(click -> bookUnmark());
//        binding.play.setOnClickListener(v -> {
//            mSeekBarTime.setMax(mMediaPlayer.getDuration());
//            if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
//                mMediaPlayer.pause();
//                play.setImageResource(R.drawable.play);
//            } else {
//                mMediaPlayer.start();
//                play.setImageResource(R.drawable.pause);
//            }
//            songProgressBar();
//        });
    }

    private void openLink(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(this.favoriteItem.getSource()));
        view.getContext().startActivity(intent);
    }

    private void showTermTexts() {
        binding.title.setText(this.favoriteItem.getTitle());
        binding.definition.setText(this.favoriteItem.getTextcontent());
        binding.source.setOnClickListener(this::openLink);
    }

    private void showMoralContent() {
        binding.moraltitle.setText(this.favoriteItem.getTitle());
        MarkdownView markdownView = binding.content;
        markdownView.loadMarkdownFile("file:///android_asset/", this.favoriteItem.getMdFile(), "file:///android_asset/style.css");
    }

    private void setUpFavoriteItemTerm() {
        this.favoriteItem.setTitle(this.getArguments().getString("title"));
        this.favoriteItem.setEnumtype(this.getArguments().getString("enumtype"));
        this.favoriteItem.setTextcontent(this.getArguments().getString("text"));
        this.favoriteItem.setSource(this.getArguments().getString("source"));
    }

    private void setUpFavoriteItemMoral() {
        this.favoriteItem.setAudiofile(this.getArguments().getString("audiolocation"));
        this.favoriteItem.setTitle(this.getArguments().getString("title"));
        this.favoriteItem.setEnumtype(this.getArguments().getString("enumtype"));
        this.favoriteItem.setMdFile(this.getArguments().getString("mdlocation"));
    }

    private void setUpDictionaryTermView() {
        binding.termlayout.setVisibility(View.VISIBLE);
        binding.morallayout.setVisibility(View.GONE);
        setUpFavoriteItemTerm();
        showTermTexts();
    }

    private void setUpDictionaryMoralTheoryOrMoralIssueView() {
        binding.morallayout.setVisibility(View.VISIBLE);
        binding.termlayout.setVisibility(View.GONE);
        setUpFavoriteItemMoral();
        showMoralContent();
    }

    private void configureTypeOfView() {
        boolean isTerm = this.getArguments().getString("mdlocation").trim().equals("");
        if (isTerm) {
            setUpDictionaryTermView();
        } else {
            setUpDictionaryMoralTheoryOrMoralIssueView();
//            setupaudio();
        }
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

//    private void setupaudio() {
//        play = binding.play;
//        mSeekBarTime = binding.seekBarTime;
//
//        int sound_id = getContext().getResources().getIdentifier(this.favoriteItem.getAudiofile(), "raw",
//                getContext().getPackageName());
//
//        mMediaPlayer = MediaPlayer.create(getContext(), sound_id);
//        mMediaPlayer.setOnCompletionListener(mediaPlayer -> play.setImageResource(R.drawable.play));
//    }

//    private void songProgressBar() {
//        // seekbar duration
//        mMediaPlayer.setOnPreparedListener(mp -> {
//            mSeekBarTime.setMax(mMediaPlayer.getDuration());
//            mMediaPlayer.start();
//        });
//
//        mSeekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if (fromUser) {
//                    mMediaPlayer.seekTo(progress);
//                    mSeekBarTime.setProgress(progress);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//
//        new Thread(() -> {
//            while (mMediaPlayer != null) {
//                try {
//                    if (mMediaPlayer.isPlaying()) {
//                        Message message = new Message();
//                        message.what = mMediaPlayer.getCurrentPosition();
//                        handler.sendMessage(message);
//                        Thread.sleep(0);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}