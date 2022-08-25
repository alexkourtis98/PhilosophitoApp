package kourtis.quadrum.philosophito.ui.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.billthefarmer.markdown.MarkdownView;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.MainActivity;

public class MoralTheoriesItemActivitiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moral_theories_item);

        String content = getIntent().getStringExtra("content");
        MarkdownView markdownView = findViewById(R.id.content);
//        markdownView.loadMarkdown(content);
        markdownView.loadMarkdownFile("file:///android_asset/" + content, "file:///android_asset/style.css");

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
}