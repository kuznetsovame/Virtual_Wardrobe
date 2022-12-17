package com.example.virtualwardrobe.screens.mainprofile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.User;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class MainProfileViewModel extends ViewModel {


    private final MutableLiveData<User> user;
    private final MutableLiveData<List<User>> friends;

    public MainProfileViewModel() {
        user = new MutableLiveData<>();
        friends = new MutableLiveData<>();


    }

    public void addFriend() {
        //wardrobeApi.sendFriedRequest();
    }

    public LiveData<List<User>> getFriends() {
        return friends;
    }



//    public List<User> showFriends() {
//        return (List<User>) wardrobeApi.getFriends(new User());
//    }

    public void setUser(User user) {
        this.user.setValue(user);
        initFirend();
    }

    public LiveData<User> getUser() {
        return user;
    }

    private void initFirend() {
        if (user.getValue() == null)
            return;
        User value1 = user.getValue();


    }

    public void setFriends(Single<List<User>> friends) {
        friends.subscribe(
                users -> {
                    this.friends.setValue(users);
                }
        );
    }
}