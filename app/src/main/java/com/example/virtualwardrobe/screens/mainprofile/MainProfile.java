package com.example.virtualwardrobe.screens.mainprofile;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.WardrobeApplication;
import com.example.virtualwardrobe.databinding.FragmentMainBinding;
import com.example.virtualwardrobe.databinding.FragmentMainProfileBinding;
import com.example.virtualwardrobe.databinding.FragmentProfileBinding;
import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.screens.profile.ProfileType;
import com.example.virtualwardrobe.screens.profile.ProfileViewModel;
import com.example.virtualwardrobe.screens.startactivity.ModelFactory;

import java.util.List;

public class MainProfile extends Fragment {

    private MainProfileViewModel viewModel;
    private FragmentMainProfileBinding binding;

    public static MainProfile newInstance() {
        return new MainProfile();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMainProfileBinding.inflate(inflater, container, false);

        WardrobeApplication application = (WardrobeApplication) getActivity().getApplication();

        viewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) new ModelFactory(application.userReopository()))
                .get(MainProfileViewModel.class);



        viewModel.getUser().observe(getViewLifecycleOwner(),
                user -> binding.tvUsername.setText(user.getUsername()));

        viewModel.getFriends().observe(getViewLifecycleOwner(), friends -> binding.tvCountFriends.setText("" + friends.size()));

        binding.llFriends.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putParcelable("user", viewModel.getUser().getValue());
            Navigation.findNavController(getView()).navigate(R.id.list_Fragment, bundle);
        });


//        binding.linearLayout2.setOnClickListener(view -> {
//            Bundle bundle = new Bundle();
//            List<User> newArray = viewModel.getFriends().getValue();
//
//            User user[] = new User[newArray.size()];
//            int i = 0;
//
//            for (User u : newArray) {
//                user[i] = u;
//                i++;
//            }
//
//            bundle.putParcelableArray("users", user);
//
//        });


        return binding.getRoot();
    }


}