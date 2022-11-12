package com.example.virtualwardrobe.ui.wardrobe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.virtualwardrobe.databinding.FragmentWardrobeBinding;

public class WardrobeFragment extends Fragment {

    private  FragmentWardrobeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WardrobeViewModel viewModel =
                new ViewModelProvider(this).get(WardrobeViewModel.class);

        binding = FragmentWardrobeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment();
                //TODO
            }
        });


        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewModel.isCorrect())
                    viewModel.save();
            }
        });

        return root;
    }
    private  void startFragment()
    {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}