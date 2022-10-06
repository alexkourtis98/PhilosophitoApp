package kourtis.quadrum.philosophito.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import kourtis.quadrum.philosophito.R;

public class QuestionsBankFragment extends Fragment {
    private View view;

    public QuestionsBankFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_questions_bank, container, false);

        this.view.findViewById(R.id.privacypolicy).setOnClickListener(item -> {
            ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new PrivacyPolicyFragment()).commit();
        });

        this.view.findViewById(R.id.donate).setOnClickListener(item -> {
            ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new DonateFragment()).commit();
        });

        return this.view;
    }
}