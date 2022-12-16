package com.example.virtualwardrobe;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.virtualwardrobe.databinding.FragmentAddClotheBinding;
import com.example.virtualwardrobe.screens.MenuActivity;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.github.dhaval2404.imagepicker.ImagePickerActivity;

import java.util.Arrays;

public class AddClothe extends Fragment {

    private AddClotheViewModel mViewModel;

    public static AddClothe newInstance() {
        return new AddClothe();
    }

    private FragmentAddClotheBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAddClotheBinding.inflate(inflater, container, false);

        Uri uri = (Uri) getArguments().get("uri");
        if(uri != null)
        {
            binding.image.setImageURI(uri);
        }

        binding.btnSave.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("type", binding.type.getItemAtPosition((int) binding.type.getSelectedItemPosition()).toString());
            intent.putExtra("name", binding.etName.getText().toString());
            intent.putExtra("description", binding.etDescription.getText().toString());
            ((MenuActivity) getActivity()).onActivityResult(120, Activity.RESULT_OK, intent);
            getParentFragment().getParentFragmentManager().popBackStack();
        });

        binding.btnBack.setOnClickListener(view -> {
            getParentFragment().getParentFragmentManager().popBackStack();
        });

        binding.getImage.setOnClickListener(view -> getImage());


        return binding.getRoot();
    }




    private void getImage() {
        ImagePicker.Companion.with(getActivity())
                .galleryOnly()
                .galleryMimeTypes(new String[]{"image/*"})//User can only select image from Gallery
                .crop()
                .maxResultSize(1080, 1080)
                .start();
    }
}