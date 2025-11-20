package kourtis.quadrum.philosophito.core.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import kourtis.quadrum.philosophito.core.data.local.entity.IssueEntity;

@Dao
public interface IssueDao {
    @Query("SELECT * FROM issues ORDER BY id ASC")
    LiveData<List<IssueEntity>> getAllIssues();

    @Query("SELECT * FROM issues WHERE id = :issueId")
    LiveData<IssueEntity> getIssueById(int issueId);

    @Query("SELECT * FROM issues WHERE enumType = :enumType")
    LiveData<IssueEntity> getIssueByEnumType(String enumType);

    @Insert
    void insertAll(List<IssueEntity> issues);

    @Insert
    long insert(IssueEntity issue);

    @Update
    void update(IssueEntity issue);

    @Query("DELETE FROM issues")
    void deleteAll();

    @Query("SELECT COUNT(*) FROM issues")
    int getCount();
}
