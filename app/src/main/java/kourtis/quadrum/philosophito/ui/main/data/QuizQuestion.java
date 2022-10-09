package kourtis.quadrum.philosophito.ui.main.data;

import androidx.annotation.NonNull;

public class QuizQuestion {

    private String questiontext;
    private int correctAnswer;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;

    public QuizQuestion() {
    }

    public QuizQuestion(String questiontext, int correctAnswer, String choiceA, String choiceB, String choiceC, String choiceD) {
        this.questiontext = questiontext;
        this.correctAnswer = correctAnswer;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    @NonNull
    @Override
    public String toString() {
        return "QuizQuestion{" +
                "questiontext='" + questiontext + '\'' +
                ", correctAnswer=" + correctAnswer +
                ", choiceA='" + choiceA + '\'' +
                ", choiceB='" + choiceB + '\'' +
                ", choiceC='" + choiceC + '\'' +
                ", choiceD='" + choiceD + '\'' +
                '}';
    }
}
