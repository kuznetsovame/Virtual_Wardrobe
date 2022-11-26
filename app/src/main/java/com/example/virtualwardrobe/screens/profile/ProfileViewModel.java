package com.example.virtualwardrobe.screens.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.network.WardrobeApi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {

    @Inject
    private WardrobeApi wardrobeApi;

    private final MutableLiveData<String> mText;
    private final MutableLiveData<User> user;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();

        mText.setValue("This is home fragment");
        user = new MutableLiveData<>();

        user.setValue(wardrobeApi.getUserById(0));
    }

    public void addFriend() {
        //wardrobeApi.sendFriedRequest();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public List<User> showFriends() {

        return (List<User>) wardrobeApi.getFriends(new User());
    }
}