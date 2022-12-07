package com.example.virtualwardrobe.screens.startactivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.virtualwardrobe.network.WardrobeApi;

public class ModelFactory extends ViewModelProvider.NewInstanceFactory {



    public ModelFactory() {
        super();
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == StartViewModel.class) {
            return (T) new StartViewModel();
        }
        return null;
    }
}