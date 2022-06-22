package com.example.myapplication.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDictionaryBinding;
import com.example.myapplication.ui.main.adapters.ListAdapterDictionary;
import com.example.myapplication.ui.main.data.DictionaryItem;
import com.example.myapplication.ui.main.data.State;

import java.util.ArrayList;
import java.util.Locale;

public class DictionaryFragment extends Fragment {

    ListView listView;
    private FragmentDictionaryBinding binding;

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