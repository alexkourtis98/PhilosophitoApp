package kourtis.quadrum.philosophito.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import org.billthefarmer.markdown.MarkdownView;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.databinding.FragmentCsrBinding;
import kourtis.quadrum.philosophito.ui.main.data.FavoriteItem;
import kourtis.quadrum.philosophito.ui.main.data.datanames;

public class CsrFragment extends Fragment {
    static MediaPlayer mMediaPlayer;
    ImageView play;
    SeekBar mSeekBarTime, mSeekBarVol;
    @SuppressLint("Handler Leak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mSeekBarTime.setProgress(msg.what);
        }
    };
    private FragmentCsrBinding binding;
    private AudioManager mAudioManager;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (!isVisibleToUser) {
                mMediaPlayer.pause();
                play.setImageResource(R.drawable.play);
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setupaudio() {

        play = binding.play;
        mSeekBarTime = binding.seekBarTime;

        mMediaPlayer = MediaPlayer.create(getContext().getApplicationContext(), R.raw.sample);

        mMediaPlayer.setOnCompletionListener(mediaPlayer -> play.setImageResource(R.drawable.play));
        play.setOnClickListener(v -> {
            mSeekBarTime.setMax(mMediaPlayer.getDuration());
            if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
                mMediaPlayer.pause();
                play.setImageResource(R.drawable.play);
            } else {
                mMediaPlayer.start();
                play.setImageResource(R.drawable.pause);
            }

            songNames();
        });
    }

    private void songNames() {
        // seekbar duration
        mMediaPlayer.setOnPreparedListener(mp -> {
            mSeekBarTime.setMax(mMediaPlayer.getDuration());
            mMediaPlayer.start();
        });

        mSeekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mMediaPlayer.seekTo(progress);
                    mSeekBarTime.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(() -> {
            while (mMediaPlayer != null) {
                try {
                    if (mMediaPlayer.isPlaying()) {
                        Message message = new Message();
                        message.what = mMediaPlayer.getCurrentPosition();
                        handler.sendMessage(message);
                        Thread.sleep(0);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void saveItem() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(requireContext());

        FavoriteItem favoriteItem = new FavoriteItem();
        favoriteItem.setId(datanames.CSR.toString());
        favoriteItem.setTextcontent("");
        favoriteItem.setTitle("Corporate Social Responsibility");
        favoriteItem.setMdFile("file:///android_asset/csr.md");

        SharedPreferences.Editor prefsEditor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(favoriteItem);
        prefsEditor.putString(favoriteItem.getId(), json);
        prefsEditor.apply();
    }

    private void bookMark() {
        saveItem();
        changeIconToBooked();
    }

    private void changeIconToBooked() {
        binding.bookmark.setVisibility(View.GONE);
        binding.bookmarkUnmark.setVisibility(View.VISIBLE);
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) binding.seekBarTime.getLayoutParams();
        rlp.removeRule(RelativeLayout.LEFT_OF);
        rlp.addRule(RelativeLayout.LEFT_OF, binding.bookmarkUnmark.getId());
    }

    private void changeIconToUnbooked() {
        binding.bookmark.setVisibility(View.VISIBLE);
        binding.bookmarkUnmark.setVisibility(View.GONE);
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) binding.seekBarTime.getLayoutParams();
        rlp.removeRule(RelativeLayout.LEFT_OF);
        rlp.addRule(RelativeLayout.LEFT_OF, binding.bookmark.getId());
    }

    private void removeItem() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(requireContext());
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.remove(datanames.CSR.toString());
        prefsEditor.apply();
    }

    private void bookUnmark() {
        removeItem();
        changeIconToUnbooked();
    }

    private void setBookMarkListeners() {
        binding.bookmark.setOnClickListener(click -> {
            bookMark();
            Toast.makeText(requireContext(), "Saved to Favorites", Toast.LENGTH_SHORT).show();
        });

        binding.bookmarkUnmark.setOnClickListener(click -> {
            bookUnmark();
        });
    }

    private void checkIfBooked() {

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(requireContext());
        if (mPrefs.getAll().containsKey(datanames.CSR.toString())) {
            bookMark();
        } else {
            bookUnmark();
        }
    }

    private void bookStuff() {
        setBookMarkListeners();
        checkIfBooked();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentCsrBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bookStuff();

        MarkdownView markdownView = binding.content;

        mAudioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

        markdownView.loadMarkdownFile("file:///android_asset/", "file:///android_asset/csr.md", "file:///android_asset/style.css");

        setupaudio();
        return root;
    }

    @Override
    public void onResume() {
        MarkdownView markdownView = binding.content;

        mAudioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

        markdownView.loadMarkdownFile("file:///android_asset/", "file:///android_asset/csr.md", "file:///android_asset/style.css");

        setupaudio();
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}