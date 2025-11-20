package kourtis.quadrum.philosophito.core.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import kourtis.quadrum.philosophito.core.data.local.entity.QuizEntity;
import kourtis.quadrum.philosophito.core.data.local.entity.QuizQuestionEntity;

@Dao
public interface QuizDao {
    // Quiz queries
    @Query("SELECT * FROM quizzes ORDER BY id ASC")
    LiveData<List<QuizEntity>> getAllQuizzes();

    @Query("SELECT * FROM quizzes WHERE id = :quizId")
    LiveData<QuizEntity> getQuizById(int quizId);

    @Insert
    long insertQuiz(QuizEntity quiz);

    @Insert
    void insertAllQuizzes(List<QuizEntity> quizzes);

    @Query("DELETE FROM quizzes")
    void deleteAllQuizzes();

    // Quiz Question queries
    @Query("SELECT * FROM quiz_questions WHERE quizId = :quizId ORDER BY id ASC")
    LiveData<List<QuizQuestionEntity>> getQuestionsByQuizId(int quizId);

    @Query("SELECT * FROM quiz_questions WHERE id = :questionId")
    LiveData<QuizQuestionEntity> getQuestionById(int questionId);

    @Insert
    void insertAllQuestions(List<QuizQuestionEntity> questions);

    @Insert
    long insertQuestion(QuizQuestionEntity question);

    @Query("DELETE FROM quiz_questions WHERE quizId = :quizId")
    void deleteQuestionsByQuizId(int quizId);

    @Query("DELETE FROM quiz_questions")
    void deleteAllQuestions();

    @Query("SELECT COUNT(*) FROM quizzes")
    int getQuizCount();

    @Query("SELECT COUNT(*) FROM quiz_questions WHERE quizId = :quizId")
    int getQuestionCountForQuiz(int quizId);
}
