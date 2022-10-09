package kourtis.quadrum.philosophito.ui.main.general;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import kourtis.quadrum.philosophito.MainActivity;
import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.databinding.ActivityAboutBinding;

public class AboutActivitiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAboutBinding activityAboutBinding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(activityAboutBinding.getRoot());

        activityAboutBinding.facebookbtn.setOnClickListener(v -> {
            String link = getResources().getString(R.string.about_link_facebook);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(link));
            startActivity(intent);
        });

        activityAboutBinding.linkedinbtn.setOnClickListener(v -> {
            String link = getResources().getString(R.string.about_link_linkedin);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(link));
            startActivity(intent);
        });

        activityAboutBinding.twitterbtn.setOnClickListener(v -> {
            String link = getResources().getString(R.string.about_link_twitter);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(link));
            startActivity(intent);
        });

        activityAboutBinding.instagrambtn.setOnClickListener(v -> {
            String link = getResources().getString(R.string.about_link_instagram);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(link));
            startActivity(intent);
        });

        activityAboutBinding.youtubebtn.setOnClickListener(v -> {
            String link = getResources().getString(R.string.about_link_youtube);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(link));
            startActivity(intent);
        });

        activityAboutBinding.soundcloudbtn.setOnClickListener(v -> {
            String link = getResources().getString(R.string.about_link_soundcloud);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(link));
            startActivity(intent);
        });

        activityAboutBinding.myfacebookbtn.setOnClickListener(v -> {
            String link = getResources().getString(R.string.about_me_link_facebook);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(link));
            startActivity(intent);
        });

        activityAboutBinding.mylinkedinbtn.setOnClickListener(v -> {
            String link = getResources().getString(R.string.about_me_link_linkedin);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(link));
            startActivity(intent);
        });

        activityAboutBinding.mytwitterbtn.setOnClickListener(v -> {
            String link = getResources().getString(R.string.about_me_link_twitter);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(link));
            startActivity(intent);
        });

        activityAboutBinding.myinstagrambtn.setOnClickListener(v -> {
            String link = getResources().getString(R.string.about_me_link_instagram);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(link));
            startActivity(intent);
        });

        activityAboutBinding.myyoutubebtn.setOnClickListener(v -> {
            String link = getResources().getString(R.string.about_me_link_youtube);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(link));
            startActivity(intent);
        });

        activityAboutBinding.logoimg.setOnClickListener(click -> {
            Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(startIntent);
        });
    }
}