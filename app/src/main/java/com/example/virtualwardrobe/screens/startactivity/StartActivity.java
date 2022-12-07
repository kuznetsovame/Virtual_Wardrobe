package com.example.virtualwardrobe.screens.startactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.databinding.ActivityStartBinding;
import com.example.virtualwardrobe.screens.MenuActivity;
import com.example.virtualwardrobe.screens.signin.SignInFragment;
import com.example.virtualwardrobe.screens.signup.SignUpFragment;


public class StartActivity extends AppCompatActivity implements SignInFragment.onClickSignUp, SignUpFragment.SignInOnClick {

    private SignInFragment signIn;
    private SignUpFragment signUp;
    private ActivityStartBinding binding;
    private StartViewModel viewModel;

    @SuppressLint("CommitTransaction")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        viewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) new ModelFactory()).get(StartViewModel.class);
        if (savedInstanceState == null) {
            signIn = SignInFragment.newInstance(this);
            signUp = SignUpFragment.newInstance(this);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment, signIn, "signIn")
                    .add(R.id.fragment, signUp, "signUp")
                    .show(signIn)
                    .hide(signUp)
                    .commit();
        } else {
            signIn = (SignInFragment) getSupportFragmentManager().findFragmentByTag("signIn");
            signUp = (SignUpFragment) getSupportFragmentManager().findFragmentByTag("signUp");
        }
    }

    @Override
    public void onClickSignUp() {
        getSupportFragmentManager().beginTransaction()
                .show(signUp)
                .hide(signIn)
                .commit();
    }

    @Override
    public void onClickSignIn( ) {

        getSupportFragmentManager().beginTransaction()
                .show(signIn)
                .hide(signUp)
                .commit();
    }

    @Override
    public void show() {
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }
}