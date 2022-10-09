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
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import org.billthefarmer.markdown.MarkdownView;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.databinding.FragmentFavoriteitemBinding;

public class FavoriteItemFragment extends Fragment {
    static MediaPlayer mMediaPlayer;
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
    private String title;
    private String source;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void bookMark() {
        changeIconToBooked();
    }

    private void changeIconToBooked() {
        binding.bookmark.setVisibility(View.GONE);
        binding.moralbookmarkUnmark.setVisibility(View.VISIBLE);
        binding.moralbookmark.setVisibility(View.GONE);
        binding.moralbookmarkUnmark.setVisibility(View.VISIBLE);
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) binding.seekBarTime.getLayoutParams();
        rlp.removeRule(RelativeLayout.LEFT_OF);
        rlp.addRule(RelativeLayout.LEFT_OF, binding.moralbookmarkUnmark.getId());
    }

    private void changeIconToUnbooked() {
        binding.bookmark.setVisibility(View.VISIBLE);
        binding.moralbookmarkUnmark.setVisibility(View.GONE);
        binding.moralbookmark.setVisibility(View.VISIBLE);
        binding.moralbookmarkUnmark.setVisibility(View.GONE);
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) binding.seekBarTime.getLayoutParams();
        rlp.removeRule(RelativeLayout.LEFT_OF);
        rlp.addRule(RelativeLayout.LEFT_OF, binding.moralbookmark.getId());
    }

    private void removeItem() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(requireContext());
        SharedPreferences.Editor refsEditor = prefs.edit();
        refsEditor.remove(this.title);
        refsEditor.apply();
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

        binding.bookmarkUnmark.setOnClickListener(click -> bookUnmark());

        binding.moralbookmark.setOnClickListener(click -> {
            bookMark();
            Toast.makeText(requireContext(), "Saved to Favorites", Toast.LENGTH_SHORT).show();
        });

        binding.moralbookmarkUnmark.setOnClickListener(click -> bookUnmark());
    }

    private void checkIfBooked() {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(requireContext());
        if (mPrefs.getAll().containsKey(this.title)) {
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFavoriteitemBinding.inflate(inflater, container, false);
        boolean isTerm;
        isTerm = this.getArguments().getString("mdlocation").trim().equals("");

        if (isTerm) {
            binding.termlayout.setVisibility(View.VISIBLE);
            binding.morallayout.setVisibility(View.GONE);

            this.title = this.getArguments().getString("title");
            String definition = this.getArguments().getString("text");
            this.source = this.getArguments().getString("source");
            binding.title.setText(this.title);
            binding.definition.setText(definition);

            binding.source.setOnClickListener(view -> {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(this.source));
                view.getContext().startActivity(intent);
            });

        } else {
            binding.morallayout.setVisibility(View.VISIBLE);
            binding.termlayout.setVisibility(View.GONE);
            MarkdownView markdownView = binding.content;
            String md = this.getArguments().getString("mdlocation");
            markdownView.loadMarkdownFile("file:///android_asset/", md, "file:///android_asset/style.css");
            this.title = this.getArguments().getString("title");
            binding.moraltitle.setText(this.title);
        }

        bookStuff();

        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new FavoritesFragment()).commit();
            }
        });
        setupaudio();

        return binding.getRoot();
    }

    private void setupaudio() {

        play = binding.play;
        mSeekBarTime = binding.seekBarTime;

        mMediaPlayer = MediaPlayer.create(requireContext(), R.raw.sample);

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

            songProgressBar();
        });
    }


    private void songProgressBar() {
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