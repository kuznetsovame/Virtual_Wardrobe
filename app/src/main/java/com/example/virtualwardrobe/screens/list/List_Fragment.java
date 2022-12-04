package com.example.virtualwardrobe.screens.list;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.adapters.ClothesAdapter;
import com.example.virtualwardrobe.adapters.UsersAdapter;
import com.example.virtualwardrobe.model.Clothes;
import com.example.virtualwardrobe.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class List_Fragment extends Fragment {
    private RecyclerView recyclerView;
    private ListViewModel mViewModel;


    public static List_Fragment newInstance() {
        return new List_Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);

        mViewModel = new ViewModelProvider(this).get(ListViewModel.class);
        User fr[]  = (User[]) getArguments().getParcelableArray("friends");

        UsersAdapter usersAdapter = new UsersAdapter(getContext(), Arrays.asList(fr));

        recyclerView.setAdapter(usersAdapter);

        return root;
    }


}