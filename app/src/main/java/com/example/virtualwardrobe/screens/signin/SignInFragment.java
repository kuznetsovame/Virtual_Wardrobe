package com.example.virtualwardrobe.screens.signin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.virtualwardrobe.WardrobeApplication;
import com.example.virtualwardrobe.databinding.FragmentSignInBinding;
import com.example.virtualwardrobe.model.User;

public class SignInFragment extends Fragment {

    private SignInViewModel viewModel;
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
        viewModel = new ViewModelProvider(this).get(SignInViewModel.class);

        binding.singup.setOnClickListener(view -> activity.onClickSignUp());

        binding.button.setOnClickListener(view ->
        {
            WardrobeApplication application = (WardrobeApplication) getActivity().getApplication();

            viewModel.auth(binding.login.getText().toString(), binding.password.getText().toString(), application.getWardrobeApi());
            //activity.show();
        });
        viewModel.text.observe(getViewLifecycleOwner(), s -> binding.button.setText(s));
        viewModel.toastText.observe(getViewLifecycleOwner(), s -> Toast.makeText(getContext(),s,Toast.LENGTH_LONG));

        viewModel.user.observe(getViewLifecycleOwner(), user -> {
            activity.show(user);
        });

        return binding.getRoot();
    }


    public interface onClickSignUp extends ShowMainActivity {
        public void onClickSignUp();
    }

    public interface ShowMainActivity {
        public void show(User user);
    }
}