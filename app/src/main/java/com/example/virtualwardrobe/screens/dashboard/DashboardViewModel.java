package com.example.virtualwardrobe.screens.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.ProfileType;
import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.network.WardrobeApi;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<List<User>> users;
    private WardrobeApi wardrobeApi;

    public  LiveData<List<User>> getUsers() {
        return users;
    }

    public DashboardViewModel(WardrobeApi wardrobeApi) {
        this.wardrobeApi = wardrobeApi;
        mText = new MutableLiveData<>();
        users = new MutableLiveData<>();
        initUser();
    }

    public LiveData<String> getText() {
        return mText;
    }

    private void initUser() {


        wardrobeApi.getAllUsers()
                .subscribeOn(Schedulers.computation())
                .map(users -> {
                    for (User it : users) {
                        it.type = ProfileType.FRIEND;
                    }
                    return users;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(value->{
                    users.setValue(value);

                },throwable -> {

                });
    }

}