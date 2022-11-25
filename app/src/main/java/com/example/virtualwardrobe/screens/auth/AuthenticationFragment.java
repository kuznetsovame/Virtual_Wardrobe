package com.example.virtualwardrobe.screens.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.databinding.FragmentProfileBinding;
import com.example.virtualwardrobe.screens.MenuActivity;
import com.example.virtualwardrobe.screens.profile.ProfileViewModel;

public class AuthenticationFragment extends Fragment {
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