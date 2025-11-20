package kourtis.quadrum.philosophito.core.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quizzes")
public class QuizEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private int questionCount;

    public QuizEntity(String title, String description, int questionCount) {
        this.title = title;
        this.description = description;
        this.questionCount = questionCount;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
}
