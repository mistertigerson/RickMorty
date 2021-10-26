package com.example.rickmorty.ui.fragments.detailsFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.rickmorty.R;
import com.example.rickmorty.databinding.FragmentDetailsBinding;
import com.example.rickmorty.ui.data.models.Result;
import com.example.rickmorty.ui.fragments.CharacterFragment;


public class DetailsFragment extends Fragment {
    private FragmentDetailsBinding binding;
    private Result result;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        result = (Result) getArguments().getSerializable("key");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Glide.with(binding.getRoot()).load(result.getImage()).centerCrop().
                into(binding.detailPhoto);
        binding.name.setText(result.getName());
        binding.status.setText(result.getStatus());
    }


}