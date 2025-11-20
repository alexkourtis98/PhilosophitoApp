package kourtis.quadrum.philosophito.core.data.local.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "quiz_questions",
    foreignKeys = @ForeignKey(
        entity = QuizEntity.class,
        parentColumns = "id",
        childColumns = "quizId",
        onDelete = ForeignKey.CASCADE
    ),
    indices = @Index("quizId")
)
public class QuizQuestionEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int quizId;
    private String questionText;
    private int correctAnswerIndex;  // 1-4
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String explanation;  // Optional explanation for the correct answer

    public QuizQuestionEntity(int quizId, String questionText, int correctAnswerIndex,
                              String optionA, String optionB, String optionC, String optionD,
                              String explanation) {
        this.quizId = quizId;
        this.questionText = questionText;
        this.correctAnswerIndex = correctAnswerIndex;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.explanation = explanation;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
