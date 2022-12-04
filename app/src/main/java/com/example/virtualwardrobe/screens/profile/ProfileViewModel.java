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
    WardrobeApi wardrobeApi;

    private final MutableLiveData<String> mText;
    private final MutableLiveData<User> user;
    private final MutableLiveData<ArrayList<User>> friends;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();

        mText.setValue("This is home fragment");
        user = new MutableLiveData<>();
        friends = new MutableLiveData<>();
        test();
        //user.setValue(wardrobeApi.getUserById(0));
    }

    public void addFriend() {
        //wardrobeApi.sendFriedRequest();
    }

    public LiveData<ArrayList<User>> getFriends() {
        return friends;
    }

    public LiveData<String> getText() {
        return mText;
    }

//    public List<User> showFriends() {
//        return (List<User>) wardrobeApi.getFriends(new User());
//    }

    public void setUser(User user) {
        this.user.setValue(user);
    }

    public  LiveData<User> getUser() {
        return user;
    }


    public void test(){
        ArrayList<User> list = new ArrayList<>();

        for(int i=0; i< 10;i++)
            list.add(new User("" + i, "asdasd" + i));

        friends.setValue(list);
    }

}