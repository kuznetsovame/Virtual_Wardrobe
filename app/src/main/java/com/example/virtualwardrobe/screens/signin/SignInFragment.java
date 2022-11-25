package com.example.virtualwardrobe.screens.signin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.virtualwardrobe.screens.profile.ProfileViewModel;

public class SignInFragment extends Fragment {
    EditText login;
    EditText password;
    Button button;
    TextView singup;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProfileViewModel homeViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);



    }

}