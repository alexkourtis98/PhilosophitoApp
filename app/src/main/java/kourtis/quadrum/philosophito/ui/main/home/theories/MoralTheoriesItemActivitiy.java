package kourtis.quadrum.philosophito.ui.main.home.theories;

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
import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.core.util.AppConstants;
import kourtis.quadrum.philosophito.core.util.IntentKeys;
import kourtis.quadrum.philosophito.ui.main.data.FavoriteItem;
import kourtis.quadrum.philosophito.ui.main.data.Theory;
import kourtis.quadrum.philosophito.ui.main.general.AboutActivitiy;

/**
 * Activity for displaying detailed information about a moral theory.
 * Shows markdown content and allows users to bookmark/favorite the theory.
 *
 * <p>Receives the following Intent extras:
 * <ul>
 *   <li>{@link IntentKeys#EXTRA_TITLE} - Theory title</li>
 *   <li>{@link IntentKeys#EXTRA_MD_LOCATION} - Markdown file path</li>
 *   <li>{@link IntentKeys#EXTRA_ENUM_TYPE} - Theory type enum</li>
 *   <li>{@link IntentKeys#EXTRA_AUDIO_LOCATION} - Audio file path (optional)</li>
 * </ul>
 *
 * @version 2.0
 * @see MoralTheoriesFragment
 * @see Theory
 */
public class MoralTheoriesItemActivitiy extends AppCompatActivity {

    // Instance variables (not static to avoid memory leaks)
    private MediaPlayer mMediaPlayer;
    private final Theory theory = new Theory();
    private ImageView play;
    private SeekBar mSeekBarTime;
    private SeekBarHandler handler;

    /**
     * Static inner Handler class to prevent memory leaks.
     * Uses WeakReference to avoid holding strong reference to Activity.
     */
    private static class SeekBarHandler extends Handler {
        private final WeakReference<MoralTheoriesItemActivitiy> activityRef;

        SeekBarHandler(MoralTheoriesItemActivitiy activity) {
            super(Looper.getMainLooper());
            this.activityRef = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            MoralTheoriesItemActivitiy activity = activityRef.get();
            if (activity != null && activity.mSeekBarTime != null) {
                activity.mSeekBarTime.setProgress(msg.what);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moral_theories_item);

        handler = new SeekBarHandler(this);
        setTheory();
        setUpUI();
        setBtns();
        setupTitle();
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
     * Builds a FavoriteItem from the current theory
     */
    private FavoriteItem buildFavoriteItem() {
        FavoriteItem favoriteItem = new FavoriteItem();
        favoriteItem.setMdFile(this.theory.getMdLocation());
        favoriteItem.setTitle(this.theory.getTitle());
        favoriteItem.setEnumtype(this.theory.getEnumtype());
        favoriteItem.setAudiofile(this.theory.getAudioLocation());
        return favoriteItem;
    }

    /**
     * Saves the current theory to favorites using SharedPreferences
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
     * Removes the current theory from favorites
     */
    private void removeItem() {
        SharedPreferences prefs = getSharedPreferences(
                AppConstants.PREFS_NAME,
                Context.MODE_PRIVATE
        );
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(this.theory.getEnumtype());
        editor.apply();
    }

    /**
     * Bookmarks the current theory and updates UI
     */
    private void bookMark() {
        saveItem();
        changeIconToBooked();
    }

    /**
     * Removes bookmark from current theory and updates UI
     */
    private void bookUnmark() {
        removeItem();
        changeIconToUnbooked();
    }

    /**
     * Updates UI to show theory is bookmarked
     */
    private void changeIconToBooked() {
        findViewById(R.id.bookmark).setVisibility(View.GONE);
        findViewById(R.id.bookmarkUnmark).setVisibility(View.VISIBLE);
    }

    /**
     * Updates UI to show theory is not bookmarked
     */
    private void changeIconToUnbooked() {
        findViewById(R.id.bookmark).setVisibility(View.VISIBLE);
        findViewById(R.id.bookmarkUnmark).setVisibility(View.GONE);
    }

    /**
     * Sets up bookmark button click listeners
     */
    private void setBookMarkListeners() {
        findViewById(R.id.bookmark).setOnClickListener(click -> {
            bookMark();
            Toast.makeText(this, "Saved to Favorites", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.bookmarkUnmark).setOnClickListener(click -> bookUnmark());
    }

    /**
     * Checks if current theory is already bookmarked and updates UI accordingly
     */
    private void checkIfBooked() {
        SharedPreferences prefs = getSharedPreferences(
                AppConstants.PREFS_NAME,
                Context.MODE_PRIVATE
        );
        if (prefs.getAll().containsKey(this.theory.getEnumtype())) {
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
     * Extracts theory data from Intent extras
     */
    private void setTheory() {
        Intent intent = getIntent();
        this.theory.setTitle(intent.getStringExtra(IntentKeys.EXTRA_TITLE));
        this.theory.setMdLocation(intent.getStringExtra(IntentKeys.EXTRA_MD_LOCATION));
        this.theory.setAudioLocation(intent.getStringExtra(IntentKeys.EXTRA_AUDIO_LOCATION));
        this.theory.setEnumtype(intent.getStringExtra(IntentKeys.EXTRA_ENUM_TYPE));
    }

    /**
     * Sets the theory title in the UI
     */
    private void setupTitle() {
        TextView titleView = findViewById(R.id.moraltitle);
        if (titleView != null && this.theory.getTitle() != null) {
            titleView.setText(this.theory.getTitle());
        }
    }

    /**
     * Sets up the main UI components
     */
    private void setUpUI() {
        MarkdownView markdownView = findViewById(R.id.content);
        if (markdownView != null && this.theory.getMdLocation() != null) {
            markdownView.loadMarkdownFile(
                    "file:///android_asset/",
                    this.theory.getMdLocation(),
                    "file:///android_asset/style.css"
            );
        }
        bookStuff();
    }

    /**
     * Sets up navigation button click listeners
     */
    private void setBtns() {
        findViewById(R.id.infoBtn).setOnClickListener(click -> {
            Intent intent = new Intent(this, AboutActivitiy.class);
            startActivity(intent);
        });

        findViewById(R.id.logoimg).setOnClickListener(click -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}
