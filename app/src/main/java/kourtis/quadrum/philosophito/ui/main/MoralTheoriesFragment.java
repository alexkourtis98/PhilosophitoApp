package kourtis.quadrum.philosophito.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.databinding.FragmentMoralTheoriesBinding;
import kourtis.quadrum.philosophito.ui.main.adapters.ListAdapter;
import kourtis.quadrum.philosophito.ui.main.data.State;

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
        ListAdapter listAdapter = new ListAdapter(requireContext(), R.layout.list_theory_item, State.theoriesList);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);
        listView.setFastScrollEnabled(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}