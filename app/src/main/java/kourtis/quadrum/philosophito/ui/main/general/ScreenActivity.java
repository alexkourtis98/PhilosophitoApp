package kourtis.quadrum.philosophito.ui.main.general;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import kourtis.quadrum.philosophito.MainActivity;
import kourtis.quadrum.philosophito.core.util.AppConstants;
import kourtis.quadrum.philosophito.databinding.ActivitySplashScreenBinding;

/**
 * Splash screen activity displayed on app launch.
 * Shows branding for a brief period before navigating to main activity.
 *
 * @version 2.0
 * @see MainActivity
 */
public class ScreenActivity extends AppCompatActivity {

    private Handler splashHandler;
    private Runnable splashRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySplashScreenBinding binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize handler and runnable
        splashHandler = new Handler(Looper.getMainLooper());
        splashRunnable = () -> {
            Intent intent = new Intent(ScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        };

        // Schedule transition to main activity
        splashHandler.postDelayed(splashRunnable, AppConstants.SPLASH_SCREEN_DELAY_MS);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Clean up Handler to prevent memory leaks
        if (splashHandler != null && splashRunnable != null) {
            splashHandler.removeCallbacks(splashRunnable);
        }
    }
}
