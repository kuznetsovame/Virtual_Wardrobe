package com.example.virtualwardrobe.screens.dashboard;

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

import com.example.virtualwardrobe.adapters.UsersAdapter;
import com.example.virtualwardrobe.databinding.FragmentMainBinding;
import com.example.virtualwardrobe.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentMainBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }


}