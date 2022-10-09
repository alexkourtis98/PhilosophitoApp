package kourtis.quadrum.philosophito.ui.main.home.extras;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.databinding.FragmentExtrasBinding;
import kourtis.quadrum.philosophito.ui.main.adapters.ListAdapterExtra;
import kourtis.quadrum.philosophito.ui.main.data.ExtraItem;
import kourtis.quadrum.philosophito.ui.main.data.State;

public class ExtraContentFragment extends Fragment {
    ListView listView;
    private FragmentExtrasBinding binding;
    private ArrayList<ExtraItem> localCopyOfExtras = State.extras;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExtrasBinding.inflate(inflater, container, false);
        this.listView = binding.allExtras;
        addTermsToList();
        return binding.getRoot();
    }

    private void addTermsToList() {
        ListAdapterExtra listAdapter = new ListAdapterExtra(requireContext(), R.layout.list_extra_item, localCopyOfExtras);
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