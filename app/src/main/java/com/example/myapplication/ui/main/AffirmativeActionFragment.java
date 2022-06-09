package com.example.myapplication.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentAffirmativeActionBinding;
import com.example.myapplication.ui.main.data.State;

import org.billthefarmer.markdown.MarkdownView;

public class AffirmativeActionFragment extends Fragment {

    private FragmentAffirmativeActionBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentAffirmativeActionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        String content = State.affirmativeAction.getContent();
        MarkdownView markdownView = binding.content;
        markdownView.loadMarkdown(content);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}