package com.example.virtualwardrobe.screens.startactivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.virtualwardrobe.network.WardrobeApi;
import com.example.virtualwardrobe.repository.UserReopository;
import com.example.virtualwardrobe.screens.dashboard.DashboardViewModel;
import com.example.virtualwardrobe.screens.mainprofile.MainProfile;
import com.example.virtualwardrobe.screens.mainprofile.MainProfileViewModel;
import com.example.virtualwardrobe.screens.profile.ProfileViewModel;

import java.sql.Wrapper;

public class ModelFactory extends ViewModelProvider.NewInstanceFactory {

    private UserReopository userReopository;
    private WardrobeApi wardrobeApi;

    public ModelFactory(WardrobeApi wardrobeApi) {
        this.wardrobeApi = wardrobeApi;
    }

    public ModelFactory(UserReopository userReopository) {
        this.userReopository = userReopository;
    }

    public ModelFactory() {
        super();
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == ProfileViewModel.class) {
            return (T) new ProfileViewModel(userReopository);
        }
        if (modelClass == DashboardViewModel.class) {
            return (T) new DashboardViewModel(wardrobeApi);
        }
        if(modelClass == StartViewModel.class)
            return (T) new StartViewModel();

        if (modelClass == MainProfileViewModel.class) {
            return (T) new MainProfileViewModel(userReopository);
        }

        return null;
    }
}