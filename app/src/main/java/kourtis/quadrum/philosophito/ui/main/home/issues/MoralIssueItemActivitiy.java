package kourtis.quadrum.philosophito.ui.main.home.issues;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.billthefarmer.markdown.MarkdownView;

import kourtis.quadrum.philosophito.MainActivity;
import kourtis.quadrum.philosophito.databinding.ActivityMoralIssuesItemBinding;
import kourtis.quadrum.philosophito.ui.main.data.FavoriteItem;
import kourtis.quadrum.philosophito.ui.main.data.Issue;
import kourtis.quadrum.philosophito.ui.main.general.AboutActivitiy;

public class MoralIssueItemActivitiy extends AppCompatActivity {
    static MediaPlayer mMediaPlayer;
    private final Issue moralIssue = new Issue();
    ImageView play;
    SeekBar mSeekBarTime;
    @SuppressLint({"Handler Leak", "HandlerLeak"})
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mSeekBarTime.setProgress(msg.what);
        }
    };
    private ActivityMoralIssuesItemBinding binding;

    private FavoriteItem buildFavoriteItem() {
        FavoriteItem favoriteItem = new FavoriteItem();
        favoriteItem.setTitle(this.moralIssue.getTitle());
        favoriteItem.setMdFile(this.moralIssue.getMdLocation());
        favoriteItem.setEnumtype(this.moralIssue.getEnumtype());
        favoriteItem.setAudiofile(this.moralIssue.getAudioLocation());
        return favoriteItem;
    }

    private void saveItem() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        FavoriteItem favoriteItem = buildFavoriteItem();
        SharedPreferences.Editor refsEditor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(favoriteItem);
        refsEditor.putString(favoriteItem.getEnumtype(), json);
        refsEditor.apply();
    }

    private void bookMark() {
        saveItem();
        changeIconToBooked();
    }

    private void changeIconToBooked() {
        binding.bookmark.setVisibility(View.GONE);
        binding.bookmarkUnmark.setVisibility(View.VISIBLE);
//        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) binding.seekBarTime.getLayoutParams();
//        rlp.removeRule(RelativeLayout.LEFT_OF);
//        rlp.addRule(RelativeLayout.LEFT_OF, binding.bookmarkUnmark.getId());
    }

    private void changeIconToUnbooked() {
        binding.bookmark.setVisibility(View.VISIBLE);
        binding.bookmarkUnmark.setVisibility(View.GONE);
//        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) binding.seekBarTime.getLayoutParams();
//        rlp.removeRule(RelativeLayout.LEFT_OF);
//        rlp.addRule(RelativeLayout.LEFT_OF, binding.bookmark.getId());
    }

    private void removeItem() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor refsEditor = prefs.edit();
        refsEditor.remove(this.moralIssue.getEnumtype());
        refsEditor.apply();
    }

    private void bookUnmark() {
        removeItem();
        changeIconToUnbooked();
    }

    private void setBookMarkListeners() {
        binding.bookmark.setOnClickListener(click -> {
            bookMark();
            Toast.makeText(getApplicationContext(), "Saved to Favorites", Toast.LENGTH_SHORT).show();
        });

        binding.bookmarkUnmark.setOnClickListener(click -> bookUnmark());
    }

    private void checkIfBooked() {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (mPrefs.getAll().containsKey(this.moralIssue.getEnumtype())) {
            bookMark();
        } else {
            bookUnmark();
        }
    }

    private void bookStuff() {
        setBookMarkListeners();
        checkIfBooked();
    }

    private void setMoralIssue() {
        String title = getIntent().getStringExtra("title");
        String audiolocation = getIntent().getStringExtra("audiolocation");
        String mdlocation = getIntent().getStringExtra("mdlocation");
        String enumtype = getIntent().getStringExtra("enumtype");

        this.moralIssue.setTitle(title);
        this.moralIssue.setAudioLocation(audiolocation);
        this.moralIssue.setMdLocation(mdlocation);
        this.moralIssue.setEnumtype(enumtype);
    }

    private void setMD() {
        MarkdownView markdownView = binding.content;
        markdownView.loadMarkdownFile("file:///android_asset/", this.moralIssue.getMdLocation(), "file:///android_asset/style.css");
    }

    private void setUpUI() {
        setMoralIssue();
        setMD();
        setMenuButtons();
//        setupaudio();
        setupTitle();
        bookStuff();
    }

    private void setupTitle() {
        TextView textView = binding.moraltitle;
        textView.setText(this.moralIssue.getTitle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMoralIssuesItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpUI();
    }

    private void setMenuButtons() {
        binding.infoBtn.setOnClickListener(click -> {
            Intent startIntent = new Intent(getApplicationContext(), AboutActivitiy.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(startIntent);
        });

        binding.logoimg.setOnClickListener(click -> {
            Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(startIntent);
        });
    }

//    private void setupaudio() {
//        play = binding.play;
//        mSeekBarTime = binding.seekBarTime;
//
//        int sound_id = getApplicationContext().getResources().getIdentifier(this.moralIssue.getAudioLocation(), "raw",
//                getApplicationContext().getPackageName());
//
//        mMediaPlayer = MediaPlayer.create(getApplicationContext(), sound_id);
//
//        mMediaPlayer.setOnCompletionListener(mediaPlayer -> play.setImageResource(R.drawable.play));
//        play.setOnClickListener(v -> {
//            mSeekBarTime.setMax(mMediaPlayer.getDuration());
//            if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
//                mMediaPlayer.pause();
//                play.setImageResource(R.drawable.play);
//            } else {
//                mMediaPlayer.start();
//                play.setImageResource(R.drawable.pause);
//            }
//
//            songProgressBar();
//        });
//    }
//
//    private void songProgressBar() {
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
}