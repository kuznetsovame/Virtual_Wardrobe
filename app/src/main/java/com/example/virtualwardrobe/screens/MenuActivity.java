package com.example.virtualwardrobe.screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.databinding.ActivityMenuBinding;
import com.example.virtualwardrobe.model.Clothe;
import com.example.virtualwardrobe.model.User;
import com.example.virtualwardrobe.screens.profile.ProfileType;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;



public class MenuActivity extends AppCompatActivity {


    private ActivityMenuBinding binding;
    private  NavController navController;
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
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_menu);
        navController.navigate(R.id.navigation_profile, bundle);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Проверяем по коду нужный результат
        if(requestCode == ImagePicker.REQUEST_CODE)
        {    Bundle bundle = new Bundle();
            bundle.putParcelable("uri", data.getData());
            Navigation.findNavController(this, R.id.nav_host_fragment_activity_menu).navigate(R.id.addClothe, bundle);
        }
        if(requestCode == 120){
            if(resultCode == Activity.RESULT_OK){
                Clothe clothes= new Clothe();
                clothes.category = data.getStringExtra("type");
                clothes.name = data.getStringExtra("name");
                clothes.description = data.getStringExtra("description");

                Bundle bundle =  new Bundle();
                bundle.putParcelable("clothe",clothes);
                Navigation.findNavController(this, R.id.nav_host_fragment_activity_menu).navigate(R.id.navigation_wardrobe,bundle);
            }else{
                //Действия при отмене
            }
        }
    }
}