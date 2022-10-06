package kourtis.quadrum.philosophito.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import kourtis.quadrum.philosophito.R;

public class QuizMenuFragment extends Fragment {
    private View view;

    public QuizMenuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_quiz_menu, container, false);

        this.view.findViewById(R.id.set1).setOnClickListener(item -> {
            ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new QuizFragment(1)).commit();
        });

        this.view.findViewById(R.id.set2).setOnClickListener(item -> {
            ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new QuizFragment(2)).commit();
        });

        this.view.findViewById(R.id.set3).setOnClickListener(item -> {
            ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new QuizFragment(3)).commit();
        });

        this.view.findViewById(R.id.set4).setOnClickListener(item -> {
            ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new QuizFragment(4)).commit();
        });

        this.view.findViewById(R.id.set5).setOnClickListener(item -> {
            ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new QuizFragment(5)).commit();
        });

        return this.view;
    }
}