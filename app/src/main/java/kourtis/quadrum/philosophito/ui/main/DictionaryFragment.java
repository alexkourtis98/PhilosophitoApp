package kourtis.quadrum.philosophito.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import kourtis.quadrum.philosophito.ui.main.data.ExtraItem;
import kourtis.quadrum.philosophito.ui.main.data.State;

public class DictionaryFragment extends Fragment {
    ListView listView;
    private FragmentDictionaryBinding binding;
    @SuppressLint("Handler Leak")
    private ArrayList<ExtraItem> localCopyOfExtras = State.extras;
    private ArrayList<DictionaryItem> localCopyOfDictionary = State.dictionary;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDictionaryBinding.inflate(inflater, container, false);
        this.listView = binding.allTerms;
        addTermsToList();

        return binding.getRoot();
    }

    private void addTermsToList() {
        ListAdapterDictionary listAdapter = new ListAdapterDictionary(getContext(), R.layout.list_item, localCopyOfDictionary);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setFastScrollEnabled(true);
        binding.searchterm.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<DictionaryItem> newArray = new ArrayList<>();

                for (DictionaryItem dictionaryItem :
                        localCopyOfDictionary) {
                    if (dictionaryItem.getTitle().toLowerCase(Locale.ROOT).contains(s.trim().toLowerCase(Locale.ROOT))) {
                        newArray.add(dictionaryItem);
                    }
                }

                ListAdapterDictionary listAdapter2 = new ListAdapterDictionary(getContext(), R.layout.list_item, newArray);
                listView.setAdapter(listAdapter2);
                listView.setClickable(true);
                listView.setFastScrollEnabled(true);
                return false;
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}