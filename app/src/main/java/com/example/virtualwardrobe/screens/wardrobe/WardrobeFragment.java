package com.example.virtualwardrobe.screens.wardrobe;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
import com.example.virtualwardrobe.screens.MenuActivity;

public class WardrobeFragment extends Fragment {

    private FragmentWardrobeBinding binding;
    private WardrobeViewModel viewModel;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Проверяем по коду нужный результат
       if (requestCode == 120) {
            if (resultCode == Activity.RESULT_OK) {

            } else {
                //Действия при отмене
            }
        }
    }

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
            Navigation.findNavController(getView()).navigate(R.id.action_navigation_wardrobe_to_addClothe);
        });

        Bundle bundle = getArguments();




        binding.rvClothes.setLayoutManager(new LinearLayoutManager(getContext()));


        ((MenuActivity) requireActivity()).clothes.observe(getViewLifecycleOwner(), clothes -> {
            binding.rvClothes.setAdapter(new ClothesAdapter(clothes));
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