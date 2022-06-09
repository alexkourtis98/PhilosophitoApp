package com.example.myapplication.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentEmploymentBinding;
import com.example.myapplication.ui.main.data.State;

import org.billthefarmer.markdown.MarkdownView;

public class EmploymentFragment extends Fragment {

    private FragmentEmploymentBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentEmploymentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        String content = State.employment.getContent();
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