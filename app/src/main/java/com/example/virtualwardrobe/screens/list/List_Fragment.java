package com.example.virtualwardrobe.screens.list;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.adapters.UsersAdapter;
import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.screens.profile.ProfileType;

import java.util.Arrays;

public class List_Fragment extends Fragment implements UsersAdapter.OnClick{
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
        User users[] = (User[]) getArguments().getParcelableArray("users");

        UsersAdapter usersAdapter = new UsersAdapter(Arrays.asList(users),this);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(usersAdapter);

        return root;
    }




    @Override
    public void onClickUserCard(User user) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("user",user);
        bundle.putSerializable("type", ProfileType.ANY_USER);
        Navigation.findNavController(getView()).navigate(R.id.navigation_profile, bundle);

    }

    @Override
    public void onClickAddUser(User user) {

    }
}