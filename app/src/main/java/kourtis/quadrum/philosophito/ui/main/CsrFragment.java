package kourtis.quadrum.philosophito.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.billthefarmer.markdown.MarkdownView;

import kourtis.quadrum.philosophito.databinding.FragmentCsrBinding;

public class CsrFragment extends Fragment {

    private FragmentCsrBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentCsrBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        MarkdownView markdownView = binding.content;

        markdownView.loadMarkdownFile("file:///android_asset/", "file:///android_asset/csr.md", "file:///android_asset/style.css");
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}