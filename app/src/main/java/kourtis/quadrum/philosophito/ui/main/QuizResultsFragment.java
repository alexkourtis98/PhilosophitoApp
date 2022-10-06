package kourtis.quadrum.philosophito.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import kourtis.quadrum.philosophito.R;

public class QuizResultsFragment extends Fragment {
    private View view;
    private String quiznametaken;
    private int mistakesnumber;
    private int correctnumber;

    public QuizResultsFragment() {
    }

    private void init() {
        showQuiznameTaken();
        showMistakesNumber();
        showCorrectNumber();
        showMessage();
    }

    private String configMessage() {
        if (this.mistakesnumber == 0) {
            return "GOOD JOB BUDDY! YOU ARE READY!";
        } else {
            return "YOU ARE ALMOST READY BUDDY. DON'T WORRY, JUST KEEP ON GOING AND STAY STRONG!";
        }
    }

    private void showMessage() {
        TextView textView = this.view.findViewById(R.id.message);
        textView.setText(configMessage());
    }

    private void showQuiznameTaken() {
        TextView textView = this.view.findViewById(R.id.quiznametaken);
        textView.setText("Test: " + this.quiznametaken);
    }

    private void showMistakesNumber() {
        TextView textView = this.view.findViewById(R.id.mistakesnumber);
        textView.setText("Number of questions answered wrong: " + this.mistakesnumber);
    }

    private void showCorrectNumber() {
        TextView textView = this.view.findViewById(R.id.correctnumber);
        textView.setText("Number of questions answered correct: " + this.correctnumber);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_results, container, false);


        this.quiznametaken = requireArguments().getString("quiznametaken");
        this.mistakesnumber = requireArguments().getInt("mistakesnumber");
        this.correctnumber = requireArguments().getInt("correctnumber");

        init();

        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new QuizMenuFragment()).commit();
            }
        });

        return this.view;
    }
}