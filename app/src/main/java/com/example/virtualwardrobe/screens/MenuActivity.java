package com.example.virtualwardrobe.screens;

import android.os.Bundle;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.databinding.ActivityMenuBinding;
import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.model.ProfileType;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;



public class MenuActivity extends AppCompatActivity {


    private ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        Bundle arguments = getIntent().getExtras();
        Bundle bundle = new Bundle();

        bundle.putSerializable("type", ProfileType.MAIN_USER);
        bundle.putParcelable("user",(User) arguments.get("user_bundle"));

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
               R.id.mainFragment, R.id.navigation_wardrobe,R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_menu);
        navController.navigate(R.id.navigation_profile, bundle);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
}