package kourtis.quadrum.philosophito.core.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import kourtis.quadrum.philosophito.core.data.local.entity.TheoryEntity;

@Dao
public interface TheoryDao {
    @Query("SELECT * FROM theories ORDER BY id ASC")
    LiveData<List<TheoryEntity>> getAllTheories();

    @Query("SELECT * FROM theories WHERE id = :theoryId")
    LiveData<TheoryEntity> getTheoryById(int theoryId);

    @Query("SELECT * FROM theories WHERE enumType = :enumType")
    LiveData<TheoryEntity> getTheoryByEnumType(String enumType);

    @Insert
    void insertAll(List<TheoryEntity> theories);

    @Insert
    long insert(TheoryEntity theory);

    @Update
    void update(TheoryEntity theory);

    @Query("DELETE FROM theories")
    void deleteAll();

    @Query("SELECT COUNT(*) FROM theories")
    int getCount();
}
