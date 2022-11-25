package com.example.virtualwardrobe;

import com.example.virtualwardrobe.network.WardrobeApi;

import javax.inject.Inject;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class WardrobeApplication {
    @Inject
    private WardrobeApi wardrobeApi;

}
