package kourtis.quadrum.philosophito.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.billthefarmer.markdown.MarkdownView;

import kourtis.quadrum.philosophito.databinding.FragmentWhistleblowingBinding;

public class WhistleBlowingFragment extends Fragment {

    private FragmentWhistleblowingBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {


        binding = FragmentWhistleblowingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        MarkdownView markdownView = binding.content;
        markdownView.loadMarkdownFile("file:///android_asset/whistleblowing.md", "file:///android_asset/style.css");
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}