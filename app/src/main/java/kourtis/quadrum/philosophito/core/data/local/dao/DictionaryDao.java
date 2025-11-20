package kourtis.quadrum.philosophito.core.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import kourtis.quadrum.philosophito.core.data.local.entity.DictionaryEntity;

@Dao
public interface DictionaryDao {
    @Query("SELECT * FROM dictionary ORDER BY title COLLATE NOCASE ASC")
    LiveData<List<DictionaryEntity>> getAllDictionaryItems();

    @Query("SELECT * FROM dictionary WHERE title LIKE '%' || :query || '%' COLLATE NOCASE ORDER BY title ASC")
    LiveData<List<DictionaryEntity>> searchDictionaryItems(String query);

    @Query("SELECT * FROM dictionary WHERE id = :id")
    LiveData<DictionaryEntity> getDictionaryItemById(int id);

    @Insert
    void insertAll(List<DictionaryEntity> items);

    @Insert
    long insert(DictionaryEntity item);

    @Update
    void update(DictionaryEntity item);

    @Query("DELETE FROM dictionary")
    void deleteAll();

    @Query("SELECT COUNT(*) FROM dictionary")
    int getCount();
}
