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
import com.example.virtualwardrobe.WardrobeApplication;
import com.example.virtualwardrobe.databinding.FragmentProfileBinding;
import com.example.virtualwardrobe.databinding.FragmentSignUpBinding;
import com.example.virtualwardrobe.screens.signin.SignInFragment;

public class SignUpFragment extends Fragment {


   private SignInOnClick activity;

    private SingUpViewModel viewModel;

    private FragmentSignUpBinding binding;


    public SignUpFragment(SignInOnClick activity) {
        this.activity = activity;
    }

    public static SignUpFragment newInstance(SignInOnClick activity) {
        return new SignUpFragment(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(this).get(SingUpViewModel.class);

        binding = FragmentSignUpBinding.inflate(inflater, container, false);


        binding.signIn.findViewById(R.id.signIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onClickSignIn();
            }
        });

        WardrobeApplication application = (WardrobeApplication) getActivity().getApplication();


        binding.button.setOnClickListener(view -> {
            if (checkLogPas()) {
                if (viewModel.reg(application.getWardrobeApi(), binding.login.getText().toString(), binding.password.getText().toString(),binding.mail.getText().toString())) {

                }
            }
        });

        return binding.getRoot();
    }

    private boolean checkLogPas() {
        if (binding.password.getText().length() < 6 && binding.password.getText().length() > 20)
            return false;
        if(!binding.confirm.getText().toString().equals(binding.password.getText().toString()))
            return false;

        //TODO:  eMail

        return true;
    }


    public interface SignInOnClick extends SignInFragment.ShowMainActivity
    {
        public void onClickSignIn();
    }
}