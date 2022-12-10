package com.example.virtualwardrobe.screens.signin;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.network.WardrobeApi;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.HttpException;

public class SignInViewModel extends ViewModel {


    MutableLiveData<String> text;
    MutableLiveData<String> toastText;
    MutableLiveData<User> user;


    public SignInViewModel() {
        text = new MutableLiveData<>("SignIn");
        toastText = new MutableLiveData<>();
        user = new MutableLiveData<>();
    }

    boolean auth(String mail, String pass, WardrobeApi wardrobeApi) {
        User user = new User();
        user.mail = mail;
        user.password = pass;

        wardrobeApi.authUser(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(value -> {
                    this.user.setValue(value);
                }, throwable -> {
                    HttpException exception = (HttpException) throwable;

                    switch (exception.code())
                    {
                        case 400:
                                toastText.setValue(throwable.getMessage());
                            break;
                        default:
                            toastText.setValue(throwable.getMessage());
                    }
                });
        return true;
    }

}
