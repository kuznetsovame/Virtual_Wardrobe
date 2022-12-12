package com.example.virtualwardrobe.screens.startactivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.virtualwardrobe.network.WardrobeApi;
import com.example.virtualwardrobe.screens.dashboard.DashboardViewModel;
import com.example.virtualwardrobe.screens.profile.ProfileViewModel;

public class ModelFactory extends ViewModelProvider.NewInstanceFactory {

    static WardrobeApi wardrobeApi;

    public ModelFactory(WardrobeApi wardrobeApi) {
        this.wardrobeApi = wardrobeApi;
    }

    public ModelFactory() {
        super();
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == ProfileViewModel.class) {
            return (T) new ProfileViewModel(wardrobeApi);
        }
        if (modelClass == DashboardViewModel.class) {
            return (T) new DashboardViewModel(wardrobeApi);
        }
        if(modelClass == StartViewModel.class)
            return (T) new StartViewModel();

        return null;
    }
}