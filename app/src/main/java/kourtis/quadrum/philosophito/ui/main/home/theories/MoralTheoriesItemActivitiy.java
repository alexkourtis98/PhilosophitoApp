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
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.billthefarmer.markdown.MarkdownView;

import kourtis.quadrum.philosophito.MainActivity;
import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.ui.main.data.FavoriteItem;
import kourtis.quadrum.philosophito.ui.main.data.datanames;
import kourtis.quadrum.philosophito.ui.main.general.AboutActivitiy;

public class MoralTheoriesItemActivitiy extends AppCompatActivity {
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
    private String title = "";
    private String enumtitle = "";

    private void saveItem() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        datanames enumtype;
        String mdfile = "";
        if (this.title.equals("Utilitarianism")) {
            enumtype = datanames.UTIL;
            this.enumtitle = datanames.UTIL.toString();
            mdfile = "file:///android_asset/util.md";
        } else if (this.title.equals("Kantianism")) {
            enumtype = datanames.KANT;
            this.enumtitle = datanames.KANT.toString();
            mdfile = "file:///android_asset/kantianism.md";
        } else {
            enumtype = datanames.VIRTUE;
            this.enumtitle = datanames.VIRTUE.toString();
            mdfile = "file:///android_asset/virtueethics.md";
        }

        FavoriteItem favoriteItem = new FavoriteItem();
        favoriteItem.setId(enumtitle);
        favoriteItem.setTextcontent("");
        favoriteItem.setTitle(this.title);
        favoriteItem.setMdFile(mdfile);
        favoriteItem.setEnumtype(enumtype.name());
        String audiofile = "R.raw.sample";
        favoriteItem.setAudiofile(audiofile);

        SharedPreferences.Editor refsEditor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(favoriteItem);
        refsEditor.putString(favoriteItem.getTitle(), json);
        refsEditor.apply();
    }

    private void bookMark() {
        saveItem();
        changeIconToBooked();
    }

    private void changeIconToBooked() {
        findViewById(R.id.bookmark).setVisibility(View.GONE);
        findViewById(R.id.bookmarkUnmark).setVisibility(View.VISIBLE);
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) findViewById(R.id.seekBarTime).getLayoutParams();
        rlp.removeRule(RelativeLayout.LEFT_OF);
        rlp.addRule(RelativeLayout.LEFT_OF, findViewById(R.id.bookmarkUnmark).getId());
    }

    private void changeIconToUnbooked() {
        findViewById(R.id.bookmark).setVisibility(View.VISIBLE);
        findViewById(R.id.bookmarkUnmark).setVisibility(View.GONE);
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) findViewById(R.id.seekBarTime).getLayoutParams();
        rlp.removeRule(RelativeLayout.LEFT_OF);
        rlp.addRule(RelativeLayout.LEFT_OF, findViewById(R.id.bookmark).getId());
    }

    private void removeItem() {
        // TODO here what ?
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor refsEditor = prefs.edit();
        refsEditor.remove(this.title);
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
        if (this.title.equals("Utilitarianism")) {
            this.enumtitle = datanames.UTIL.toString();
        } else if (this.title.equals("Kantianism")) {
            this.enumtitle = datanames.KANT.toString();
        } else {
            this.enumtitle = datanames.VIRTUE.toString();
        }

        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moral_theories_item);

        String content = getIntent().getStringExtra("content");
        this.title = getIntent().getStringExtra("title");
        MarkdownView markdownView = findViewById(R.id.content);
        markdownView.loadMarkdownFile("file:///android_asset/", "file:///android_asset/" + content, "file:///android_asset/style.css");
        bookStuff();

        TextView textView = findViewById(R.id.theorytitle);
        textView.setText(getIntent().getStringExtra("title"));
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
        setupaudio();

    }

    private void setupaudio() {

        play = findViewById(R.id.play);
        mSeekBarTime = findViewById(R.id.seekBarTime);

        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sample);

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
}