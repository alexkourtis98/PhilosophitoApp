package kourtis.quadrum.philosophito.ui.main.quiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.core.util.AppConstants;
import kourtis.quadrum.philosophito.core.util.IntentKeys;
import kourtis.quadrum.philosophito.ui.main.data.QuizQuestion;
import kourtis.quadrum.philosophito.ui.main.data.State;

/**
 * Fragment for displaying and managing quiz questions.
 * Handles quiz progression, answer validation, and score tracking.
 *
 * @version 2.0
 * @see QuizQuestion
 * @see QuizResultsFragment
 */
public class QuizFragment extends Fragment {
    private static final String TAG = "QuizFragment";

    private View view;
    private int set;
    private int correct;
    private String questionsetTitle;
    private int currentquestionindex;
    private int maxquestions;
    private boolean tried = false;
    private ArrayList<QuizQuestion> questionsSet = new ArrayList<>();

    /**
     * Constructor with quiz set number
     *
     * @param set Quiz set number (1-based)
     */
    public QuizFragment(int set) {
        this.set = set - 1;
        this.questionsSet = State.getQuestionsSetByNum(this.set);
        this.currentquestionindex = 0;
        this.maxquestions = this.questionsSet.size();
        this.correct = 0;
    }

    /**
     * Required empty public constructor
     */
    public QuizFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_quiz, container, false);

        initQuiz();
        setChoiceListeners();
        setupBackPressHandler(container);

        return this.view;
    }

    /**
     * Sets up back press handling
     */
    private void setupBackPressHandler(ViewGroup container) {
        requireActivity().getOnBackPressedDispatcher().addCallback(
                getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        if (container != null && container.getContext() instanceof AppCompatActivity) {
                            ((AppCompatActivity) container.getContext())
                                    .getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.frame, new QuizMenuFragment())
                                    .commit();
                        }
                    }
                }
        );
    }

    /**
     * Initializes quiz UI with first question
     */
    private void initQuiz() {
        setChoiceA();
        setChoiceB();
        setChoiceC();
        setChoiceD();
        setInfoQuestions();
        setInfoCorrects();
        setTopTitle();
        setQuestion();
    }

    /**
     * Sets the quiz set title
     */
    private void setTopTitle() {
        TextView textView = this.view.findViewById(R.id.quizsettitle);
        if (textView != null) {
            String number = String.valueOf(this.currentquestionindex + 1);
            this.questionsetTitle = "Quiz Set " + number;
            textView.setText(this.questionsetTitle);
        }
    }

    /**
     * Sets the question text
     */
    private void setQuestion() {
        if (!isValidQuestionIndex()) return;

        TextView textView = this.view.findViewById(R.id.questiontext);
        QuizQuestion question = questionsSet.get(currentquestionindex);
        if (textView != null && question != null && question.getQuestiontext() != null) {
            textView.setText(question.getQuestiontext());
        }
    }

    /**
     * Sets choice A text
     */
    private void setChoiceA() {
        if (!isValidQuestionIndex()) return;

        TextView textView = this.view.findViewById(R.id.choiceA);
        QuizQuestion question = questionsSet.get(currentquestionindex);
        if (textView != null && question != null && question.getChoiceA() != null) {
            textView.setText(question.getChoiceA());
        }
    }

    /**
     * Sets choice B text
     */
    private void setChoiceB() {
        if (!isValidQuestionIndex()) return;

        TextView textView = this.view.findViewById(R.id.choiceB);
        QuizQuestion question = questionsSet.get(currentquestionindex);
        if (textView != null && question != null && question.getChoiceB() != null) {
            textView.setText(question.getChoiceB());
        }
    }

    /**
     * Sets choice C text
     */
    private void setChoiceC() {
        if (!isValidQuestionIndex()) return;

        TextView textView = this.view.findViewById(R.id.choiceC);
        QuizQuestion question = questionsSet.get(currentquestionindex);
        if (textView != null && question != null && question.getChoiceC() != null) {
            textView.setText(question.getChoiceC());
        }
    }

    /**
     * Sets choice D text
     */
    private void setChoiceD() {
        if (!isValidQuestionIndex()) return;

        TextView textView = this.view.findViewById(R.id.choiceD);
        QuizQuestion question = questionsSet.get(currentquestionindex);
        if (textView != null && question != null && question.getChoiceD() != null) {
            textView.setText(question.getChoiceD());
        }
    }

    /**
     * Validates that current question index is within bounds
     */
    private boolean isValidQuestionIndex() {
        if (questionsSet == null || currentquestionindex < 0 ||
                currentquestionindex >= questionsSet.size()) {
            Log.e(TAG, AppConstants.ERROR_INVALID_QUESTION + currentquestionindex);
            return false;
        }
        return true;
    }

    /**
     * Sets up click listeners for all choice buttons
     */
    private void setChoiceListeners() {
        Button choiceA = this.view.findViewById(R.id.choiceA);
        Button choiceB = this.view.findViewById(R.id.choiceB);
        Button choiceC = this.view.findViewById(R.id.choiceC);
        Button choiceD = this.view.findViewById(R.id.choiceD);

        if (choiceA != null) {
            choiceA.setOnClickListener(choice -> {
                disableSelectedBtn(AppConstants.CHOICE_A);
                checkAnswer(AppConstants.CHOICE_A);
            });
        }
        if (choiceB != null) {
            choiceB.setOnClickListener(choice -> {
                disableSelectedBtn(AppConstants.CHOICE_B);
                checkAnswer(AppConstants.CHOICE_B);
            });
        }
        if (choiceC != null) {
            choiceC.setOnClickListener(choice -> {
                disableSelectedBtn(AppConstants.CHOICE_C);
                checkAnswer(AppConstants.CHOICE_C);
            });
        }
        if (choiceD != null) {
            choiceD.setOnClickListener(choice -> {
                disableSelectedBtn(AppConstants.CHOICE_D);
                checkAnswer(AppConstants.CHOICE_D);
            });
        }
    }

    /**
     * Checks if selected answer is correct
     */
    private void checkAnswer(int selectedchoice) {
        if (!isValidQuestionIndex()) return;

        if (selectedchoice == this.questionsSet.get(this.currentquestionindex).getCorrectAnswer()) {
            correctAnswerMechanism();
        } else {
            wrongAnswerMechanism();
        }
    }

    /**
     * Handles correct answer logic
     */
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

    /**
     * Handles wrong answer logic
     */
    private void wrongAnswerMechanism() {
        this.tried = true;
        wrongAnswerToast();
    }

    /**
     * Shows quiz results fragment
     */
    private void showResults() {
        int mistakesnumber = this.maxquestions - this.correct;
        Bundle bundle = new Bundle();
        bundle.putString(IntentKeys.EXTRA_TITLE, this.questionsetTitle);
        bundle.putInt(IntentKeys.EXTRA_QUIZ_SCORE, this.correct);
        bundle.putInt(IntentKeys.EXTRA_QUIZ_TOTAL, this.maxquestions);

        QuizResultsFragment quizResultsFragment = new QuizResultsFragment();
        quizResultsFragment.setArguments(bundle);

        if (this.view != null && this.view.getContext() instanceof AppCompatActivity) {
            ((AppCompatActivity) this.view.getContext())
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, quizResultsFragment)
                    .commit();
        }
    }

    /**
     * Displays correct answer status
     */
    private void correctAnswerToast() {
        TextView textView = this.view.findViewById(R.id.status);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.success));
            textView.setText("CORRECT");
        }
    }

    /**
     * Displays wrong answer status
     */
    private void wrongAnswerToast() {
        TextView textView = this.view.findViewById(R.id.status);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.fail));
            textView.setText("WRONG");
        }
    }

    /**
     * Clears the status message
     */
    private void clearStatus() {
        TextView textView = this.view.findViewById(R.id.status);
        if (textView != null) {
            textView.setText("");
        }
    }

    /**
     * Waits before proceeding to next question
     */
    private void waitabit() {
        new CountDownTimer(AppConstants.QUIZ_ANSWER_FEEDBACK_DELAY_MS, 1000) {
            @Override
            public void onTick(long l) {
                // No action needed
            }

            @Override
            public void onFinish() {
                validateAllButtons();
                clearStatus();
            }
        }.start();
    }

    /**
     * Enables all choice buttons
     */
    private void validateAllButtons() {
        Button choiceA = this.view.findViewById(R.id.choiceA);
        Button choiceB = this.view.findViewById(R.id.choiceB);
        Button choiceC = this.view.findViewById(R.id.choiceC);
        Button choiceD = this.view.findViewById(R.id.choiceD);

        if (choiceA != null) choiceA.setEnabled(true);
        if (choiceB != null) choiceB.setEnabled(true);
        if (choiceC != null) choiceC.setEnabled(true);
        if (choiceD != null) choiceD.setEnabled(true);
    }

    /**
     * Disables the selected choice button
     */
    private void disableSelectedBtn(int choiceselected) {
        Button choice = null;

        if (choiceselected == AppConstants.CHOICE_A) {
            choice = this.view.findViewById(R.id.choiceA);
        } else if (choiceselected == AppConstants.CHOICE_B) {
            choice = this.view.findViewById(R.id.choiceB);
        } else if (choiceselected == AppConstants.CHOICE_C) {
            choice = this.view.findViewById(R.id.choiceC);
        } else if (choiceselected == AppConstants.CHOICE_D) {
            choice = this.view.findViewById(R.id.choiceD);
        }

        if (choice != null) {
            choice.setEnabled(false);
        }
    }

    /**
     * Advances to the next question
     */
    private void goToNextQuestion() {
        this.tried = false;
        this.currentquestionindex++;
        setChoiceA();
        setChoiceB();
        setChoiceC();
        setChoiceD();
        setInfoQuestions();
        setInfoCorrects();
        setQuestion();
    }

    /**
     * Updates the correct answers counter
     */
    private void setInfoCorrects() {
        String text = "Answered correctly " + this.correct;
        TextView textView = this.view.findViewById(R.id.infocorrects);
        if (textView != null) {
            textView.setText(text);
        }
    }

    /**
     * Updates the question counter
     */
    private void setInfoQuestions() {
        String text = "Question " + (this.currentquestionindex + 1) + " out of " + maxquestions;
        TextView textView = this.view.findViewById(R.id.infoquestions);
        if (textView != null) {
            textView.setText(text);
        }
    }
}
