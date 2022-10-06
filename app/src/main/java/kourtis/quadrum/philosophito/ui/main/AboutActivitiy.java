package kourtis.quadrum.philosophito.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import kourtis.quadrum.philosophito.MainActivity;
import kourtis.quadrum.philosophito.R;

public class AboutActivitiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ImageView facebookbtn = findViewById(R.id.facebookbtn);
        facebookbtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.facebook.com/Philosophito-103166662422236"));
            startActivity(intent);
        });

        ImageView linkedinbtn = findViewById(R.id.linkedinbtn);
        linkedinbtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.linkedin.com/groups/9233252/"));
            startActivity(intent);
        });

        ImageView twitterbtn = findViewById(R.id.twitterbtn);
        twitterbtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://twitter.com/Philosophito"));
            startActivity(intent);
        });

        ImageView instagrambtn = findViewById(R.id.instagrambtn);
        instagrambtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.instagram.com/philosophitoapp/"));
            startActivity(intent);
        });


        ImageView youtubebtn = findViewById(R.id.youtubebtn);
        youtubebtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.youtube.com/channel/UCEXXpqKRW15LlMGDCQOvfGA"));
            startActivity(intent);
        });

        ImageView soundcloudbtn = findViewById(R.id.soundcloudbtn);
        soundcloudbtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://soundcloud.com/akourtis-dev/adasadadsd"));
            startActivity(intent);
        });


        findViewById(R.id.logoimg).setOnClickListener(click -> {
            Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(startIntent);
        });
    }

    @Override
    public void onBackPressed() {
        Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
        startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(startIntent);
    }
}