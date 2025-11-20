package kourtis.quadrum.philosophito.core.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import kourtis.quadrum.philosophito.core.data.local.PhilosophitoDatabase;
import kourtis.quadrum.philosophito.core.data.local.dao.TheoryDao;
import kourtis.quadrum.philosophito.core.data.local.entity.TheoryEntity;

/**
 * Repository for Theory data
 * Provides a clean API for ViewModels to access theory data
 * Abstracts the data source (Room database)
 */
public class TheoryRepository {
    private final TheoryDao theoryDao;
    private final LiveData<List<TheoryEntity>> allTheories;

    public TheoryRepository(Application application) {
        PhilosophitoDatabase database = PhilosophitoDatabase.getDatabase(application);
        theoryDao = database.theoryDao();
        allTheories = theoryDao.getAllTheories();
    }

    /**
     * Get all theories (observed by UI)
     */
    public LiveData<List<TheoryEntity>> getAllTheories() {
        return allTheories;
    }

    /**
     * Get theory by ID (observed by UI)
     */
    public LiveData<TheoryEntity> getTheoryById(int theoryId) {
        return theoryDao.getTheoryById(theoryId);
    }

    /**
     * Get theory by enum type (observed by UI)
     */
    public LiveData<TheoryEntity> getTheoryByEnumType(String enumType) {
        return theoryDao.getTheoryByEnumType(enumType);
    }

    /**
     * Insert new theory (background thread)
     */
    public void insert(TheoryEntity theory) {
        PhilosophitoDatabase.databaseWriteExecutor.execute(() -> {
            theoryDao.insert(theory);
        });
    }

    /**
     * Update existing theory (background thread)
     */
    public void update(TheoryEntity theory) {
        PhilosophitoDatabase.databaseWriteExecutor.execute(() -> {
            theoryDao.update(theory);
        });
    }
}
