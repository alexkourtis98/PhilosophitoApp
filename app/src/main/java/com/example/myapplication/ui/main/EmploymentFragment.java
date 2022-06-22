package com.example.myapplication.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentEmploymentBinding;

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

        MarkdownView markdownView = binding.content;
        markdownView.loadMarkdownFile("file:///android_asset/employment.md", "file:///android_asset/style.css");
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}