package com.example.virtualwardrobe.screens.dashboard;

import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.virtualwardrobe.R;
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
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainFragment extends Fragment implements UsersAdapter.OnClick {

    private FragmentMainBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this, (ViewModelProvider.Factory) new ModelFactory(((WardrobeApplication) (getActivity().getApplication())).getWardrobeApi())).get(DashboardViewModel.class);


        binding = FragmentMainBinding.inflate(inflater, container, false);


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        MainFragment mainFragment = this;
        UserReopository userReopository = ((WardrobeApplication) getActivity().getApplication()).userReopository();
        List<User> userList = userReopository.getUserList();

        binding.recyclerView.setAdapter(new UsersAdapter(userList, this));

        binding.editTextTextPersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              Observable.fromIterable(userReopository.getUserList())
                      .subscribeOn(Schedulers.io())
                      .observeOn(AndroidSchedulers.mainThread())
                      .filter( user -> user.username.contains(charSequence) || user.mail.contains((charSequence)))
                      .toList()
                      .subscribe(users ->{
                          binding.recyclerView.setAdapter(new UsersAdapter(users, mainFragment));
                      });
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return binding.getRoot();
    }


    @Override
    public void onClickUserCard(User user) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("user",user);
        Navigation.findNavController(getView()).navigate(R.id.action_mainFragment_to_profileFragment,bundle);
    }

    @Override
    public void onClickAddUser(User user) {

    }
}