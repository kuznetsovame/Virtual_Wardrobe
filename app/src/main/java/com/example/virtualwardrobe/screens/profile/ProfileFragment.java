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

        WardrobeApplication application = (WardrobeApplication) getActivity().getApplication();

        ProfileViewModel viewModel =
                new ViewModelProvider(this, (ViewModelProvider.Factory) new ModelFactory(application.getWardrobeApi())).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        User _user = (User) getArguments().get("user");
        if(_user!= null) {
            viewModel.setUser(_user);
            setType((ProfileType) getArguments().get("type"));
        }


        viewModel.getUser().observe(getViewLifecycleOwner(), user -> binding.tvUsername.setText(user.getUsername()));
        viewModel.getFriends().observe(getViewLifecycleOwner(), friends -> binding.tvCountFriends.setText("" + friends.size()));

        viewModel.getFriends().observe(getViewLifecycleOwner(),users -> {
            binding.tvCountFriends.setText("" + users.size());
        });

        binding.linearLayout2.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            List<User> newArray = viewModel.getFriends().getValue();

            User user[] = new User[newArray.size()];
            int i=0;

            for (User u : newArray) {
                user[i] = u;
                i++;
            }

            bundle.putParcelableArray("users", user);
            Navigation.findNavController(root).navigate(R.id.list_Fragment, bundle);
            //Navigation.findNavController(this, R.id.nav_host_fragment_activity_menu);
        });

        //binding.linearLayout3.setOnClickListener(view -> viewModel.showFriends());
        //binding.linearLayout3.setOnClickListener(view -> viewModel.showFriends());

        return root;
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