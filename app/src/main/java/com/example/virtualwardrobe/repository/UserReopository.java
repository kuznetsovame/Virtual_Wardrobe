package com.example.virtualwardrobe.repository;

import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.network.WardrobeApi;
import com.example.virtualwardrobe.screens.profile.ProfileType;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class UserReopository {

    private User mainUser = null;
    private List<User> userList;
    private WardrobeApi wardrobeApi;


    public UserReopository(WardrobeApi wardrobeApi) {
        this.wardrobeApi = wardrobeApi;
        updateUsers();
        userList = new ArrayList<>();
    }

    public User getMainUser() {
        return mainUser;
    }

    public void setMainUser(User mainUser) {
        this.mainUser = mainUser;
    }

    public List<User> getUserList() {

        return userList;
    }

    public void updateUsers() {
        wardrobeApi.getAllUsers()
                .subscribeOn(Schedulers.computation())
                .map(users -> {
                    for (User it : users) {
                        it.type = ProfileType.FRIEND;
                    }
                    return users;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(value -> {
                    userList.clear();
                    userList.addAll(value);

                }, throwable -> {

                });
    }

    public  Single<List<User>> getFriends(User user) {
        List<User> friends = new ArrayList<>();
        if (mainUser != null)
           return wardrobeApi.getFriends(mainUser)
                    .subscribeOn(Schedulers.computation())
                    .map(users -> {
                        for (User it : users) {
                            it.type = ProfileType.FRIEND;
                        }
                        return users;
                    })
                    .observeOn(AndroidSchedulers.mainThread());


        return null;
    }


}
