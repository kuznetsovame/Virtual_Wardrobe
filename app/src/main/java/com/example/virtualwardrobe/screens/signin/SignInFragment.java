package com.example.virtualwardrobe.screens.signin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.databinding.FragmentSignInBinding;

import java.util.ArrayList;
import java.util.List;

public class SignInFragment extends Fragment {

    private SignInViewModel mViewModel;
    private onClickSignUp activity;
    private FragmentSignInBinding binding;

    public static SignInFragment newInstance(onClickSignUp activity) {
        return new SignInFragment(activity);
    }

    public SignInFragment(onClickSignUp activity) {
        this.activity = activity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentSignInBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(this).get(SignInViewModel.class);

        binding.singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onClickSignUp();
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.show();
            }
        });

        return binding.getRoot();
    }


    public interface onClickSignUp extends ShowMainActivity {
        public void onClickSignUp();
    }

    public interface ShowMainActivity {
        public void show();
    }
}