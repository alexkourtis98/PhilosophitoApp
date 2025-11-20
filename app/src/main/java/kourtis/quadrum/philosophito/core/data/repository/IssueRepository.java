package kourtis.quadrum.philosophito.core.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import kourtis.quadrum.philosophito.core.data.local.PhilosophitoDatabase;
import kourtis.quadrum.philosophito.core.data.local.dao.IssueDao;
import kourtis.quadrum.philosophito.core.data.local.entity.IssueEntity;

/**
 * Repository for Issue data
 */
public class IssueRepository {
    private final IssueDao issueDao;
    private final LiveData<List<IssueEntity>> allIssues;

    public IssueRepository(Application application) {
        PhilosophitoDatabase database = PhilosophitoDatabase.getDatabase(application);
        issueDao = database.issueDao();
        allIssues = issueDao.getAllIssues();
    }

    public LiveData<List<IssueEntity>> getAllIssues() {
        return allIssues;
    }

    public LiveData<IssueEntity> getIssueById(int issueId) {
        return issueDao.getIssueById(issueId);
    }

    public LiveData<IssueEntity> getIssueByEnumType(String enumType) {
        return issueDao.getIssueByEnumType(enumType);
    }

    public void insert(IssueEntity issue) {
        PhilosophitoDatabase.databaseWriteExecutor.execute(() -> {
            issueDao.insert(issue);
        });
    }

    public void update(IssueEntity issue) {
        PhilosophitoDatabase.databaseWriteExecutor.execute(() -> {
            issueDao.update(issue);
        });
    }
}
