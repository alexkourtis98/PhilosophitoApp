package kourtis.quadrum.philosophito.ui.main.home.dictionary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Locale;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.databinding.FragmentDictionaryBinding;
import kourtis.quadrum.philosophito.ui.main.adapters.ListAdapterDictionary;
import kourtis.quadrum.philosophito.ui.main.data.DictionaryItem;
import kourtis.quadrum.philosophito.ui.main.data.State;

public class DictionaryFragment extends Fragment {
    private final ArrayList<DictionaryItem> localCopyOfDictionary = State.dictionary;
    private ListView listView;
    private FragmentDictionaryBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDictionaryBinding.inflate(inflater, container, false);
        this.listView = binding.allTerms;
        ListAdapter listAdapter = setUpListAdapter();
        listFunctionality(listAdapter);

        return binding.getRoot();
    }

    private void listFunctionality(ListAdapter listAdapter) {
        this.listView.setAdapter(listAdapter);
        this.listView.setClickable(true);
        this.listView.setFastScrollEnabled(true);

        binding.searchterm.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                doSearch(s);
                return false;
            }
        });
    }

    private void doSearch(String s) {
        ArrayList<DictionaryItem> newArray = new ArrayList<>();

        for (DictionaryItem dictionaryItem : localCopyOfDictionary) {
            if (dictionaryItem.getTitle().toLowerCase(Locale.ROOT).contains(s.trim().toLowerCase(Locale.ROOT))) {
                newArray.add(dictionaryItem);
            }
        }

        ListAdapterDictionary listAdapterDictionary = new ListAdapterDictionary(getContext(), R.layout.list_item, newArray);
        this.listView.setAdapter(listAdapterDictionary);
        this.listView.setClickable(true);
        this.listView.setFastScrollEnabled(true);
    }

    private ListAdapter setUpListAdapter() {
        return new ListAdapterDictionary(this.getContext(), R.layout.list_item, localCopyOfDictionary);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}