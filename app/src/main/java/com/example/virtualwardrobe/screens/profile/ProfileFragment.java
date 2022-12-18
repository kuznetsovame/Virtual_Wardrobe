package com.example.virtualwardrobe.screens.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.WardrobeApplication;
import com.example.virtualwardrobe.databinding.FragmentProfileBinding;
import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.screens.startactivity.ModelFactory;

import java.util.List;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        WardrobeApplication application = (WardrobeApplication) getActivity().getApplication();

        ProfileViewModel viewModel =
                new ViewModelProvider(this, (ViewModelProvider.Factory) new ModelFactory(application.userReopository())).get(ProfileViewModel.class);



        User _user = (User) getArguments().get("user");
        if(_user!= null) {
            viewModel.setUser(_user);

        }

        viewModel.isFriend.observe(getViewLifecycleOwner(),v -> binding.button3.setText("Remove"));
        viewModel.getUser().observe(getViewLifecycleOwner(), user -> binding.tvUsername.setText(user.getUsername()));
        viewModel.getFriends().observe(getViewLifecycleOwner(), friends -> binding.tvCountFriends.setText("" + friends.size()));

        viewModel.getFriends().observe(getViewLifecycleOwner(),users -> {
            binding.tvCountFriends.setText("" + users.size());
        });

        binding.llFriends.setOnClickListener(view -> {
        });


        return binding.getRoot();
    }


    private void setType(ProfileType type) {
        if(type== null)
            return;

        switch (type) {
            case ANY_USER:

                break;
            case MAIN_USER:
                binding.button3.setText("Edit");
                binding.button3.setOnClickListener(view -> {

                });
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}