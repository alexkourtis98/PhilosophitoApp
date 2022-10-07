package kourtis.quadrum.philosophito.ui.main;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.ui.main.data.QuizQuestion;
import kourtis.quadrum.philosophito.ui.main.data.State;

public class QuizFragment extends Fragment {
    private View view;
    private int set;
    private int correct;
    private String questionsetTitle;
    private int currentquestionindex;
    private int maxquestions;
    private boolean tried = false;
    private ArrayList<QuizQuestion> questionsSet = new ArrayList<>();

    public QuizFragment(int set) {
        this.set = set - 1;
        this.questionsSet = State.getQuestionsSetByNum(this.set);
        this.currentquestionindex = 0;
        this.maxquestions = this.questionsSet.size();
        this.correct = 0;
    }

    public QuizFragment() {
    }

    private void setTopTitle() {
        TextView textView = this.view.findViewById(R.id.quizsettitle);
        String number = String.valueOf(Integer.parseInt(String.valueOf((int) this.currentquestionindex + 1)));
        this.questionsetTitle = "Quiz Set " + number;
        textView.setText(this.questionsetTitle);
    }

    private void setQuestion() {
        TextView textView = this.view.findViewById(R.id.questiontext);
        textView.setText(this.questionsSet.get(this.currentquestionindex).getQuestiontext());
    }

    private void setChoiceA() {
        TextView textView = this.view.findViewById(R.id.questiontext);
        textView.setText(this.questionsSet.get(this.currentquestionindex).getChoiceA());
    }

    private void setChoiceB() {
        TextView textView = this.view.findViewById(R.id.questiontext);
        textView.setText(this.questionsSet.get(this.currentquestionindex).getChoiceB());
    }

    private void setChoiceC() {
        TextView textView = this.view.findViewById(R.id.questiontext);
        textView.setText(this.questionsSet.get(this.currentquestionindex).getChoiceC());
    }

    private void setChoiceD() {
        TextView textView = this.view.findViewById(R.id.questiontext);
        textView.setText(this.questionsSet.get(this.currentquestionindex).getChoiceD());
    }

    private void checkAnswer(int selectedchoice) {
        if (selectedchoice == this.questionsSet.get(this.currentquestionindex).getCorrectAnswer()) {
            correctAnswerMechanism();
        } else {
            wrongAnswerMechanism(selectedchoice);
        }
    }

    private void validateAllButtons() {
        Button choiceA = this.view.findViewById(R.id.choiceA);
        Button choiceB = this.view.findViewById(R.id.choiceB);
        Button choiceC = this.view.findViewById(R.id.choiceC);
        Button choiceD = this.view.findViewById(R.id.choiceD);
        choiceA.setEnabled(true);
        choiceB.setEnabled(true);
        choiceC.setEnabled(true);
        choiceD.setEnabled(true);
    }

    private void correctAnswerMechanism() {
        correctAnswerToast();
        if (!this.tried) {
            this.correct++;
        }
        if (this.currentquestionindex < maxquestions - 1) {
            waitabit();
            goToNextQuestion();
        } else {
            showResults();
        }
    }

    private void showResults() {
        int mistakesnumber = this.maxquestions - this.correct;
        Bundle bundle = new Bundle();
        bundle.putString("quiznametaken", this.questionsetTitle);
        bundle.putInt("mistakesnumber", mistakesnumber);
        bundle.putInt("correctnumber", this.correct);

        QuizResultsFragment quizResultsFragment = new QuizResultsFragment();
        quizResultsFragment.setArguments(bundle);

        ((AppCompatActivity) this.view.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, quizResultsFragment).commit();
    }

    private void clearStatus() {
        TextView textView = this.view.findViewById(R.id.status);
        textView.setText("");
    }

    private void correctAnswerToast() {
        TextView textView = this.view.findViewById(R.id.status);
        textView.setTextColor(getResources().getColor(R.color.success));
        textView.setText("CORRECT");
    }

    private void wrongAnswerToast() {
        TextView textView = this.view.findViewById(R.id.status);
        textView.setTextColor(getResources().getColor(R.color.fail));
        textView.setText("WRONG");
    }

    private void waitabit() {
        new CountDownTimer(1500, 1000) {
            @Override
            public void onTick(long l) {

            }

            public void onFinish() {
                validateAllButtons();
                clearStatus();
            }
        }.start();
    }

    private void disableSelectedBtn(int choiceselected) {
        Button choice;
        if (choiceselected == 1) {
            choice = this.view.findViewById(R.id.choiceA);
        } else if (choiceselected == 2) {
            choice = this.view.findViewById(R.id.choiceB);
        } else if (choiceselected == 3) {
            choice = this.view.findViewById(R.id.choiceC);
        } else {
            choice = this.view.findViewById(R.id.choiceD);
        }

        choice.setEnabled(false);
    }

    private void wrongAnswerMechanism(int choiceselected) {
        this.tried = true;
        wrongAnswerToast();
    }

    private void goToNextQuestion() {
        this.tried = false;
        this.currentquestionindex++;
        setChoiceC();
        setChoiceA();
        setChoiceB();
        setChoiceD();
        setInfoQuestions();
        setInfoCorrects();
        setQuestion();
    }

    private void setInfoCorrects() {
        String text = "Answered correctly " + this.correct;
        TextView textView = this.view.findViewById(R.id.infocorrects);
        textView.setText(text);
    }

    private void setInfoQuestions() {
        String text = "Question " + Integer.parseInt(String.valueOf((int) this.currentquestionindex + 1)) + " out of " + maxquestions;
        TextView textView = this.view.findViewById(R.id.infoquestions);
        textView.setText(text);
    }

    private void initQuizo() {
        setChoiceC();
        setChoiceA();
        setChoiceB();
        setChoiceD();
        setInfoQuestions();
        setInfoCorrects();
        setTopTitle();
        setQuestion();
    }

    private void setChoiceListeners() {
        Button choiceA = this.view.findViewById(R.id.choiceA);
        Button choiceB = this.view.findViewById(R.id.choiceB);
        Button choiceC = this.view.findViewById(R.id.choiceC);
        Button choiceD = this.view.findViewById(R.id.choiceD);
        choiceA.setOnClickListener(choice -> {
            disableSelectedBtn(1);
            checkAnswer(1);
        });
        choiceB.setOnClickListener(choice -> {
            disableSelectedBtn(2);
            checkAnswer(2);
        });
        choiceC.setOnClickListener(choice -> {
            disableSelectedBtn(3);
            checkAnswer(3);
        });
        choiceD.setOnClickListener(choice -> {
            checkAnswer(4);
            disableSelectedBtn(4);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_quiz, container, false);

        initQuizo();
        setChoiceListeners();

        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                ((AppCompatActivity) container.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new QuizMenuFragment()).commit();
            }
        });

        return this.view;
    }
}