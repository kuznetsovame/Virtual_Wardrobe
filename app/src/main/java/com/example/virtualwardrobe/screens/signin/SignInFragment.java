package com.example.virtualwardrobe.screens.signin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.screens.MenuActivity;
import com.example.virtualwardrobe.screens.profile.ProfileViewModel;


public class SignInFragment extends Fragment {
    EditText login;
    EditText password;
    Button button;
    TextView singup;

    private SingInViewModel viewModel;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root =   inflater.inflate(R.layout.activity_sign_in, container, false);;
        viewModel = new ViewModelProvider(this).get(SingInViewModel.class);


        login = root.findViewById(R.id.login);
        password = root.findViewById(R.id.password);
        button = root.findViewById(R.id.button);
        singup = root.findViewById(R.id.singup);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(checkLogPas())
                {
                    if(viewModel.auth(login.getText().toString(),password.getText().toString()))
                    {
                        showMenu();
                    }

                }
            }
        });

        return root;
    }

    private boolean checkLogPas()
    {
        if(password.getText().length() < 6 && password.getText().length()  > 20)
            return false;


        return true;
    }

    private void showMenu()
    {
        //TODO:: finish this activity and start MenuActivity
        //startActivity(new Intent(this, MenuActivity.class));

    }
}