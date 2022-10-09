package kourtis.quadrum.philosophito.ui.main.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import kourtis.quadrum.philosophito.R;

public class SettingsFragment extends Fragment {
    private View view;

    public SettingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_settings, container, false);

        this.view.findViewById(R.id.privacypolicy).setOnClickListener(item -> {
            ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new PrivacyPolicyFragment()).commit();
        });

        this.view.findViewById(R.id.donate).setOnClickListener(item -> {
            ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new DonateFragment()).commit();
        });

        this.view.findViewById(R.id.rateapp).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.facebook.com/Philosophito-103166662422236"));
            startActivity(intent);
        });

        this.view.findViewById(R.id.allapps).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.facebook.com/Philosophito-103166662422236"));
            startActivity(intent);
        });

        this.view.findViewById(R.id.sendtofriend).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.facebook.com/Philosophito-103166662422236"));
            startActivity(intent);
        });

        return this.view;
    }
}