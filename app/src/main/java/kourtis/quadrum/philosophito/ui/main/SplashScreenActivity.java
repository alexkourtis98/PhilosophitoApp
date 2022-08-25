package kourtis.quadrum.philosophito.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import kourtis.quadrum.philosophito.databinding.ActivitySplashScreenBinding;
import kourtis.quadrum.philosophito.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new Handler().postDelayed(() -> {
            Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }, 2500); //2500
    }
}