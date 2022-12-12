package com.example.virtualwardrobe.screens.signup;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.network.WardrobeApi;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.HttpException;

public class SingUpViewModel extends ViewModel {


    private MutableLiveData<String> toastText;

    public SingUpViewModel() {
        toastText = new MutableLiveData<>();
    }

    boolean reg(WardrobeApi wardrobeApi,String  username, String pass, String email)
    {
        User user = new User();
        user.mail = email;
        user.username = username;
        user.password = pass;

        wardrobeApi.regUser(user).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(value->
                {
                    System.out.println(value);
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

        return false;
    }

}
