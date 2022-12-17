package com.example.virtualwardrobe;

import android.app.Application;

import com.example.virtualwardrobe.network.WardrobeApi;
import com.example.virtualwardrobe.repository.UserReopository;

import javax.inject.Inject;

import dagger.hilt.android.HiltAndroidApp;
import retrofit2.Retrofit;

@HiltAndroidApp
public class WardrobeApplication extends Application {
    public WardrobeApi getWardrobeApi() {
        return wardrobeApi;
    }

    public UserReopository userReopository() {
        return userReopository;
    }

    @Inject
    WardrobeApi wardrobeApi;
    @Inject
    UserReopository userReopository;

}
