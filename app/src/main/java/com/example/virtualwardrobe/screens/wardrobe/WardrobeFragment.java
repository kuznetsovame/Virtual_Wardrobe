package com.example.virtualwardrobe.screens.wardrobe;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.adapters.ClothesAdapter;
import com.example.virtualwardrobe.databinding.FragmentWardrobeBinding;
import com.example.virtualwardrobe.model.Clothe;

public class WardrobeFragment extends Fragment {

    private FragmentWardrobeBinding binding;
    private WardrobeViewModel viewModel;


    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {
        super.startActivity(intent, options);
        Clothe clothes = intent.getParcelableExtra("clothe");
        if(clothes != null)
        {
            viewModel.addCloth(clothes);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(WardrobeViewModel.class);

        binding = FragmentWardrobeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.tvAdd.setOnClickListener(view -> {
            Navigation.findNavController(getView()).navigate(R.id.addClothe);
        });



        binding.rvClothes.setLayoutManager(new LinearLayoutManager(getContext()));


        viewModel.clothes.observe(getViewLifecycleOwner(), clothes -> {
            binding.rvClothes.setAdapter(new ClothesAdapter(viewModel.clothes.getValue()));
        });

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewModel.isCorrect())
                    viewModel.save();
            }
        });


        return root;
    }

    public void addClothe(Clothe clothe) {
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}