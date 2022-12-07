package com.example.virtualwardrobe.screens.startactivity;

import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.network.WardrobeApi;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.Disposable;

public class StartViewModel extends ViewModel {

    @Inject
    public WardrobeApi wardrobeApi;

    Disposable disposable;

    public StartViewModel() {
    }


}
