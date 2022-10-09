package kourtis.quadrum.philosophito.ui.main.home.dictionary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.databinding.FragmentDictionaryitemBinding;
import kourtis.quadrum.philosophito.ui.main.data.FavoriteItem;

public class DictionaryItemFragment extends Fragment {
    private FragmentDictionaryitemBinding binding;
    private String title;
    private String definition;
    private String source;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void saveItem() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(requireContext());

        FavoriteItem favoriteItem = new FavoriteItem();
        favoriteItem.setId(this.title);
        favoriteItem.setTextcontent(this.definition);
        favoriteItem.setTitle(this.title);
        favoriteItem.setMdFile("");
        favoriteItem.setSource(this.source);

        SharedPreferences.Editor refsEditor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(favoriteItem);
        refsEditor.putString(favoriteItem.getTitle(), json);
        refsEditor.apply();
    }

    private void bookMark() {
        saveItem();
        changeIconToBooked();
    }

    private void changeIconToBooked() {
        binding.bookmark.setVisibility(View.GONE);
        binding.bookmarkUnmark.setVisibility(View.VISIBLE);
    }

    private void changeIconToUnbooked() {
        binding.bookmark.setVisibility(View.VISIBLE);
        binding.bookmarkUnmark.setVisibility(View.GONE);
    }

    private void removeItem() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(requireContext());
        SharedPreferences.Editor refsEditor = prefs.edit();
        refsEditor.remove(this.title);
        refsEditor.apply();
    }

    private void bookUnmark() {
        removeItem();
        changeIconToUnbooked();
    }

    private void setBookMarkListeners() {
        binding.bookmark.setOnClickListener(click -> {
            bookMark();
            Toast.makeText(requireContext(), "Saved to Favorites", Toast.LENGTH_SHORT).show();
        });

        binding.bookmarkUnmark.setOnClickListener(click -> {
            bookUnmark();
        });
    }

    private void checkIfBooked() {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(requireContext());
        if (mPrefs.getAll().containsKey(this.title)) {
            bookMark();
        } else {
            bookUnmark();
        }
    }

    private void bookStuff() {
        setBookMarkListeners();
        checkIfBooked();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDictionaryitemBinding.inflate(inflater, container, false);
        this.title = this.getArguments().getString("title");
        this.definition = this.getArguments().getString("definition");
        this.source = this.getArguments().getString("source");
        binding.title.setText(this.title);
        binding.definition.setText(this.definition);

        binding.source.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(this.source));
            view.getContext().startActivity(intent);
        });
        bookStuff();
        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                container.getRootView().findViewById(R.id.mywrapperlayout).setVisibility(View.VISIBLE);
                binding.dictitemwrapper.setVisibility(View.GONE);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}