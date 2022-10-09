package kourtis.quadrum.philosophito.ui.main.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.databinding.FragmentFavoritesBinding;
import kourtis.quadrum.philosophito.ui.main.adapters.ListAdapterFavorites;
import kourtis.quadrum.philosophito.ui.main.data.State;

public class FavoritesFragment extends Fragment {
    ListView listView;
    private FragmentFavoritesBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false);
        this.listView = binding.allTerms;
        addTermsToList();

        return binding.getRoot();
    }

    private void addTermsToList() {
        State.loadFavorites(getContext());
        ListAdapterFavorites listAdapter = new ListAdapterFavorites(this.getContext(), R.layout.list_favorite_item, State.favorites);
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