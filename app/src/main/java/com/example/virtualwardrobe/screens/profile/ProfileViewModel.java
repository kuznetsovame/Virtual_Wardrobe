package com.example.virtualwardrobe.screens.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.ProfileType;
import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.network.WardrobeApi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ProfileViewModel extends ViewModel {
    WardrobeApi wardrobeApi;

    private final MutableLiveData<String> mText;
    private final MutableLiveData<User> user;
    private final MutableLiveData<List<User>> friends;

    public ProfileViewModel(WardrobeApi wardrobeApi) {
        mText = new MutableLiveData<>();

        mText.setValue("This is home fragment");
        user = new MutableLiveData<>();
        friends = new MutableLiveData<>();
        this.wardrobeApi = wardrobeApi;

    }

    public void addFriend() {
        //wardrobeApi.sendFriedRequest();
    }

    public LiveData<List<User>> getFriends() {
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
        initFirend();
    }

    public  LiveData<User> getUser() {
        return user;
    }

    private void initFirend() {
        if(user.getValue() == null)
            return;
        User value1 = user.getValue();
        wardrobeApi.getFriends(value1)
                .subscribeOn(Schedulers.computation())
                .map(users -> {
                    for (User it : users) {
                        it.type = ProfileType.FRIEND;
                    }
                    return users;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(value->{
                    friends.setValue(value);

                },throwable -> {

                });

    }


}