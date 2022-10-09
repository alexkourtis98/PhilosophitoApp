package kourtis.quadrum.philosophito.ui.main.home.issues;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.databinding.FragmentMoralIssuesBinding;
import kourtis.quadrum.philosophito.ui.main.adapters.ListAdapterIssue;
import kourtis.quadrum.philosophito.ui.main.data.State;

public class MoralIssuesFragment extends Fragment {
    ListView listView;
    private FragmentMoralIssuesBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMoralIssuesBinding.inflate(inflater, container, false);
        this.listView = binding.allIssues;
        addMoralIssuesToList();
        return binding.getRoot();
    }

    private void addMoralIssuesToList() {
        ListAdapterIssue listAdapterTheory = new ListAdapterIssue(requireContext(), R.layout.list_issue_item, State.issuesList);
        listView.setAdapter(listAdapterTheory);
        listView.setClickable(true);
        listView.setFastScrollEnabled(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}