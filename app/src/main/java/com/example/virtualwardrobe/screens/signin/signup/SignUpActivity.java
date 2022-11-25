package com.example.virtualwardrobe.screens.signin.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.virtualwardrobe.R;
import com.example.virtualwardrobe.screens.MenuActivity;

public class SignUpActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_menu();
            }
        });
    }
    void show_menu() {
        startActivity(new Intent(this, MenuActivity.class));
    }
}