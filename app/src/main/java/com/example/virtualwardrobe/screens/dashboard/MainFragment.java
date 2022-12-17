package com.example.virtualwardrobe.screens.dashboard;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.virtualwardrobe.WardrobeApplication;
import com.example.virtualwardrobe.adapters.UsersAdapter;
import com.example.virtualwardrobe.databinding.FragmentMainBinding;
import com.example.virtualwardrobe.model.Clothe;
import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.repository.UserReopository;
import com.example.virtualwardrobe.screens.startactivity.ModelFactory;
import com.example.virtualwardrobe.screens.startactivity.StartViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hilt_aggregated_deps._dagger_hilt_android_internal_managers_HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;

public class MainFragment extends Fragment implements UsersAdapter.OnClick {

    private FragmentMainBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this, (ViewModelProvider.Factory) new ModelFactory(((WardrobeApplication) (getActivity().getApplication())).getWardrobeApi())).get(DashboardViewModel.class);


        binding = FragmentMainBinding.inflate(inflater, container, false);


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        UserReopository userReopository = ((WardrobeApplication) getActivity().getApplication()).userReopository();
        List<User> userList = userReopository.getUserList();
        UsersAdapter adapter = new UsersAdapter(userList, this);
        binding.recyclerView.setAdapter(adapter);


        return binding.getRoot();
    }


    @Override
    public void onClickUserCard(User user) {

    }

    @Override
    public void onClickAddUser(User user) {

    }
}