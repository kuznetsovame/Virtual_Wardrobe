package com.example.virtualwardrobe.screens.signin;


import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.network.WardrobeApi;

import javax.inject.Inject;

public class SignInViewModel extends ViewModel {

    @Inject
    WardrobeApi wardrobeApi;


    public SignInViewModel() {
    }

    boolean auth(String mail, String pass)
    {
        User user = new User();
        user.mail = mail;
        user.password = pass;

        String  hash =  wardrobeApi.authUser(user);

        return !hash.isEmpty();
    }

}
