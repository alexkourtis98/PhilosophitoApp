package kourtis.quadrum.philosophito.feature.dictionary.presentation;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

import kourtis.quadrum.philosophito.core.data.local.entity.DictionaryEntity;
import kourtis.quadrum.philosophito.core.data.repository.DictionaryRepository;

/**
 * ViewModel for Dictionary feature
 * Manages UI state and business logic for dictionary
 * Survives configuration changes (rotation)
 */
public class DictionaryViewModel extends AndroidViewModel {
    private final DictionaryRepository repository;
    private final LiveData<List<DictionaryEntity>> allDictionaryItems;
    private final MutableLiveData<String> searchQuery = new MutableLiveData<>("");
    private final LiveData<List<DictionaryEntity>> searchResults;

    public DictionaryViewModel(@NonNull Application application) {
        super(application);
        repository = new DictionaryRepository(application);
        allDictionaryItems = repository.getAllDictionaryItems();

        // Set up search functionality
        searchResults = Transformations.switchMap(searchQuery, query -> {
            if (query == null || query.trim().isEmpty()) {
                return allDictionaryItems;
            } else {
                return repository.searchDictionaryItems(query);
            }
        });
    }

    /**
     * Get all dictionary items (or search results if searching)
     */
    public LiveData<List<DictionaryEntity>> getDictionaryItems() {
        return searchResults;
    }

    /**
     * Search dictionary items
     */
    public void search(String query) {
        searchQuery.setValue(query);
    }

    /**
     * Get dictionary item by ID
     */
    public LiveData<DictionaryEntity> getDictionaryItemById(int id) {
        return repository.getDictionaryItemById(id);
    }
}
