package com.example.virtualwardrobe.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.User;

import java.util.ArrayList;
import java.util.List;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public void addFriend() {

    }

    public LiveData<String> getText() {
        return mText;
    }

    public List<User> showFriends() {

        return new ArrayList<>();
    }
}