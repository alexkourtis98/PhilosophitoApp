package kourtis.quadrum.philosophito.core.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import kourtis.quadrum.philosophito.core.data.local.PhilosophitoDatabase;
import kourtis.quadrum.philosophito.core.data.local.dao.DictionaryDao;
import kourtis.quadrum.philosophito.core.data.local.entity.DictionaryEntity;

/**
 * Repository for Dictionary data
 */
public class DictionaryRepository {
    private final DictionaryDao dictionaryDao;
    private final LiveData<List<DictionaryEntity>> allDictionaryItems;

    public DictionaryRepository(Application application) {
        PhilosophitoDatabase database = PhilosophitoDatabase.getDatabase(application);
        dictionaryDao = database.dictionaryDao();
        allDictionaryItems = dictionaryDao.getAllDictionaryItems();
    }

    public LiveData<List<DictionaryEntity>> getAllDictionaryItems() {
        return allDictionaryItems;
    }

    public LiveData<List<DictionaryEntity>> searchDictionaryItems(String query) {
        return dictionaryDao.searchDictionaryItems(query);
    }

    public LiveData<DictionaryEntity> getDictionaryItemById(int id) {
        return dictionaryDao.getDictionaryItemById(id);
    }

    public void insert(DictionaryEntity item) {
        PhilosophitoDatabase.databaseWriteExecutor.execute(() -> {
            dictionaryDao.insert(item);
        });
    }

    public void update(DictionaryEntity item) {
        PhilosophitoDatabase.databaseWriteExecutor.execute(() -> {
            dictionaryDao.update(item);
        });
    }
}
