package com.example.virtualwardrobe.screens.signup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.screens.signin.SignInFragment;

public class SignUpFragment extends Fragment {

    EditText login;
    EditText password;
    EditText confirm;
    Button button;
    TextView singup;
   private SignInOnClick activity;

    private SingUpViewModel viewModel;

    public SignUpFragment(SignInOnClick activity) {
        this.activity = activity;
    }

    public static SignUpFragment newInstance(SignInOnClick activity) {
        return new SignUpFragment(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sign_up, container, false);
        viewModel = new ViewModelProvider(this).get(SingUpViewModel.class);


        login = root.findViewById(R.id.login);
        password = root.findViewById(R.id.password);
        button = root.findViewById(R.id.button);
        confirm = root.findViewById(R.id.confirm);
        root.findViewById(R.id.signIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onClickSignIn();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (checkLogPas()) {
                    if (viewModel.reg(login.getText().toString(), password.getText().toString())) {

                    }

                }
            }
        });

        return root;
    }

    private boolean checkLogPas() {
        if (password.getText().length() < 6 && password.getText().length() > 20)
            return false;
        if(!confirm.getText().toString().equals(password.getText().toString()))
            return false;

        //TODO:  eMail

        return true;
    }


    public interface SignInOnClick extends SignInFragment.ShowMainActivity
    {
        public void onClickSignIn();
    }
}