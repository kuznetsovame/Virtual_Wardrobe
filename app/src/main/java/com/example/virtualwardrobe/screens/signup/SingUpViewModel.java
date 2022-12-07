package com.example.virtualwardrobe.screens.signup;


import androidx.lifecycle.ViewModel;

import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.network.WardrobeApi;

import javax.inject.Inject;

public class SingUpViewModel extends ViewModel {

    @Inject
    WardrobeApi wardrobeApi;


    public SingUpViewModel() {
    }

    boolean reg(String mail, String pass)
    {
        User user = new User();
        user.mail = mail;
        user.password = pass;

        String  hash =  "";

        return !hash.isEmpty();
    }

}
