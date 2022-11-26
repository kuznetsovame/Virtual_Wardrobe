package com.example.virtualwardrobe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.virtualwardrobe.screens.signin.SignInFragment;

public class StartActivity extends AppCompatActivity {

    @SuppressLint("CommitTransaction")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        SignInFragment fragment = new SignInFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction f =  fragmentManager.beginTransaction();

       // f .add(R.id.fragment, fragment);

    }




}