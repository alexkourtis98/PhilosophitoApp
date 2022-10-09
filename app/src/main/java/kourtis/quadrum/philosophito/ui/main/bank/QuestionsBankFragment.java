package kourtis.quadrum.philosophito.ui.main.bank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.ui.main.settings.DonateFragment;
import kourtis.quadrum.philosophito.ui.main.settings.PrivacyPolicyFragment;

public class QuestionsBankFragment extends Fragment {

    public QuestionsBankFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questions_bank, container, false);

        view.findViewById(R.id.privacypolicy).setOnClickListener(item -> {
            ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new PrivacyPolicyFragment()).commit();
        });

        view.findViewById(R.id.donate).setOnClickListener(item -> {
            ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new DonateFragment()).commit();
        });

        return view;
    }
}