package kourtis.quadrum.philosophito.ui.main.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.ui.main.settings.SettingsFragment;

public class PrivacyPolicyFragment extends Fragment {

    public PrivacyPolicyFragment() {
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new SettingsFragment()).commit();
            }
        });

        return inflater.inflate(R.layout.fragment_privacypolicy, container, false);
    }
}