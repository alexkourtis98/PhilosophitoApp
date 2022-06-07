package com.example.myapplication.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentMoralTheoriesBinding;
import com.example.myapplication.ui.main.data.State;

public class MoralTheoriesFragment extends Fragment {

    ListView listView;
    private FragmentMoralTheoriesBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMoralTheoriesBinding.inflate(inflater, container, false);
        this.listView = binding.allTheories;
        addMoralTheoriesToList();
        return binding.getRoot();
    }

    private void addMoralTheoriesToList() {
        ListAdapter listAdapter = new ListAdapter(getContext(), R.layout.list_item, State.theoriesList);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setFastScrollEnabled(true);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(getActivity(), MoralTheoriesItemActivitiy.class);
            intent.putExtra("title", State.theoriesList.get(i).getTitle());
            intent.putExtra("content", State.theoriesList.get(i).getFullContent());
            startActivity(intent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}