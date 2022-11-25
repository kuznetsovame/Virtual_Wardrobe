package com.example.virtualwardrobe;

import android.app.Application;

import com.example.virtualwardrobe.network.WardrobeApi;

import javax.inject.Inject;

import dagger.hilt.android.HiltAndroidApp;
import retrofit2.Retrofit;

@HiltAndroidApp
public class WardrobeApplication extends Application {
    @Inject
    WardrobeApi wardrobeApi;

}
