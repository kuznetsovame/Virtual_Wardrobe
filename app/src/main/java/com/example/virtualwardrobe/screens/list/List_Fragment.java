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
import com.example.virtualwardrobe.WardrobeApplication;
import com.example.virtualwardrobe.adapters.UsersAdapter;
import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.screens.profile.ProfileType;

import java.util.Arrays;

public class List_Fragment extends Fragment implements UsersAdapter.OnClick{
    private RecyclerView recyclerView;


    public static List_Fragment newInstance() {
        return new List_Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        WardrobeApplication application = (WardrobeApplication) getActivity().getApplication();
        Bundle arguments = getArguments();

        if(arguments.containsKey("user"))
        {
            application.userReopository().getFriends((User) arguments.get("user"))
                    .subscribe(
                            users -> {
                                RecyclerView.Adapter adapter = new UsersAdapter( users ,this);
                                recyclerView.setAdapter(adapter);
                            }
                    );

        }
        else
        {

        }





        return root;
    }




    @Override
    public void onClickUserCard(User user) {

        Bundle bundle = new Bundle();

        bundle.putParcelable("user",user);
        bundle.putSerializable("type", ProfileType.ANY_USER);
        Navigation.findNavController(getView()).navigate(R.id.profileFragment, bundle);

    }

    @Override
    public void onClickAddUser(User user) {

    }
}