package com.example.virtualwardrobe.screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.databinding.ActivityMenuBinding;
import com.example.virtualwardrobe.model.Clothe;
import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.screens.dashboard.MainFragment;
import com.example.virtualwardrobe.screens.profile.ProfileFragment;
import com.example.virtualwardrobe.screens.profile.ProfileType;
import com.example.virtualwardrobe.screens.signin.SignInFragment;
import com.example.virtualwardrobe.screens.signup.SignUpFragment;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;


public class MenuActivity extends AppCompatActivity {


    private ActivityMenuBinding binding;
    private NavController navController;

    public MutableLiveData<List<Clothe>> clothes = new MutableLiveData<>(new ArrayList<>());

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.






        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.mainFragment, R.id.navigation_wardrobe, R.id.mainProfile)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_menu);
        NavigationUI.setupWithNavController(binding.navView, navController);


    }


}