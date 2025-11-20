package kourtis.quadrum.philosophito.core.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import kourtis.quadrum.philosophito.core.data.local.PhilosophitoDatabase;
import kourtis.quadrum.philosophito.core.data.local.dao.QuizDao;
import kourtis.quadrum.philosophito.core.data.local.entity.QuizEntity;
import kourtis.quadrum.philosophito.core.data.local.entity.QuizQuestionEntity;

/**
 * Repository for Quiz data
 */
public class QuizRepository {
    private final QuizDao quizDao;
    private final LiveData<List<QuizEntity>> allQuizzes;

    public QuizRepository(Application application) {
        PhilosophitoDatabase database = PhilosophitoDatabase.getDatabase(application);
        quizDao = database.quizDao();
        allQuizzes = quizDao.getAllQuizzes();
    }

    public LiveData<List<QuizEntity>> getAllQuizzes() {
        return allQuizzes;
    }

    public LiveData<QuizEntity> getQuizById(int quizId) {
        return quizDao.getQuizById(quizId);
    }

    public LiveData<List<QuizQuestionEntity>> getQuestionsByQuizId(int quizId) {
        return quizDao.getQuestionsByQuizId(quizId);
    }

    public LiveData<QuizQuestionEntity> getQuestionById(int questionId) {
        return quizDao.getQuestionById(questionId);
    }

    public void insertQuiz(QuizEntity quiz) {
        PhilosophitoDatabase.databaseWriteExecutor.execute(() -> {
            quizDao.insertQuiz(quiz);
        });
    }

    public void insertQuestion(QuizQuestionEntity question) {
        PhilosophitoDatabase.databaseWriteExecutor.execute(() -> {
            quizDao.insertQuestion(question);
        });
    }
}
