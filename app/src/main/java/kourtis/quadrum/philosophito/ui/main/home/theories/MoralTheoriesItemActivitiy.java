package kourtis.quadrum.philosophito.ui.main.home.theories;

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
import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.ui.main.data.FavoriteItem;
import kourtis.quadrum.philosophito.ui.main.data.Theory;
import kourtis.quadrum.philosophito.ui.main.general.AboutActivitiy;

public class MoralTheoriesItemActivitiy extends AppCompatActivity {
    static MediaPlayer mMediaPlayer;
    private final String mdfile = "";
    private final Theory theory = new Theory();
    ImageView play;
    SeekBar mSeekBarTime;
    @SuppressLint({"Handler Leak", "HandlerLeak"})
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mSeekBarTime.setProgress(msg.what);
        }
    };

    private FavoriteItem buildFavoriteItem() {
        FavoriteItem favoriteItem = new FavoriteItem();
        favoriteItem.setMdFile(this.theory.getMdLocation());
        favoriteItem.setTitle(this.theory.getTitle());
        favoriteItem.setEnumtype(this.theory.getEnumtype());
        favoriteItem.setAudiofile(this.theory.getAudioLocation());
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
        findViewById(R.id.bookmark).setVisibility(View.GONE);
        findViewById(R.id.bookmarkUnmark).setVisibility(View.VISIBLE);
//        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) findViewById(R.id.seekBarTime).getLayoutParams();
//        rlp.removeRule(RelativeLayout.LEFT_OF);
//        rlp.addRule(RelativeLayout.LEFT_OF, findViewById(R.id.bookmarkUnmark).getId());
    }

    private void changeIconToUnbooked() {
        findViewById(R.id.bookmark).setVisibility(View.VISIBLE);
        findViewById(R.id.bookmarkUnmark).setVisibility(View.GONE);
//        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) findViewById(R.id.seekBarTime).getLayoutParams();
//        rlp.removeRule(RelativeLayout.LEFT_OF);
//        rlp.addRule(RelativeLayout.LEFT_OF, findViewById(R.id.bookmark).getId());
    }

    private void removeItem() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor refsEditor = prefs.edit();
        refsEditor.remove(this.theory.getEnumtype());
        refsEditor.apply();
    }

    private void bookUnmark() {
        removeItem();
        changeIconToUnbooked();
    }

    private void setBookMarkListeners() {
        findViewById(R.id.bookmark).setOnClickListener(click -> {
            bookMark();
            Toast.makeText(getApplicationContext(), "Saved to Favorites", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.bookmarkUnmark).setOnClickListener(click -> {
            bookUnmark();
        });
    }

    private void checkIfBooked() {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (mPrefs.getAll().containsKey(this.theory.getEnumtype())) {
            bookMark();
        } else {
            bookUnmark();
        }
    }

    private void bookStuff() {
        setBookMarkListeners();
        checkIfBooked();
    }

    private void setTheory() {
        this.theory.setTitle(getIntent().getStringExtra("title"));
        this.theory.setMdLocation(getIntent().getStringExtra("mdLocation"));
        this.theory.setAudioLocation(getIntent().getStringExtra("audioLocation"));
        this.theory.setEnumtype(getIntent().getStringExtra("enumtype"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moral_theories_item);
        setTheory();
        setUpUI();
        setBtns();
        setuptitle();
//        setupaudio();
    }

    private void setuptitle() {
        ((TextView) findViewById(R.id.moraltitle)).setText(this.theory.getTitle());
    }

    private void setUpUI() {
        MarkdownView markdownView = findViewById(R.id.content);
        markdownView.loadMarkdownFile("file:///android_asset/", this.theory.getMdLocation(), "file:///android_asset/style.css");
        bookStuff();
    }

    private void setBtns() {
        findViewById(R.id.infoBtn).setOnClickListener(click -> {
            Intent startIntent = new Intent(getApplicationContext(), AboutActivitiy.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(startIntent);
        });

        findViewById(R.id.logoimg).setOnClickListener(click -> {
            Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(startIntent);
        });
    }
//
//    private void setupaudio() {
//
//        play = findViewById(R.id.play);
//        mSeekBarTime = findViewById(R.id.seekBarTime);
//
//        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sample);
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
//
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
}