package kourtis.quadrum.philosophito.ui.main;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.billthefarmer.markdown.MarkdownView;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.databinding.FragmentDiscriminationBinding;

public class DiscriminationFragment extends Fragment {
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
    private FragmentDiscriminationBinding binding;
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

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentDiscriminationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MarkdownView markdownView = binding.content;
        markdownView.loadMarkdownFile("file:///android_asset/", "file:///android_asset/discrimination.md", "file:///android_asset/style.css");

        setupaudio();
        return root;
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}