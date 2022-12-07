package com.example.virtualwardrobe.screens.wardrobe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.adapters.ClothesAdapter;
import com.example.virtualwardrobe.databinding.FragmentWardrobeBinding;
import com.example.virtualwardrobe.model.Clothes;

public class WardrobeFragment extends Fragment {

    private  FragmentWardrobeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        WardrobeViewModel viewModel =
                new ViewModelProvider(this).get(WardrobeViewModel.class);

        binding = FragmentWardrobeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        binding.tvAdd.setOnClickListener(view -> {
            Navigation.findNavController(getView()).navigate(R.id.addClothe);
        });


        ClothesAdapter adapter = new ClothesAdapter(viewModel.clothes.getValue());

        binding.rvClothes.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvClothes.setAdapter(adapter);

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewModel.isCorrect())
                    viewModel.save();
            }
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}