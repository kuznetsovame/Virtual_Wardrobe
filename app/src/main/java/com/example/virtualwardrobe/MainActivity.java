package com.example.virtualwardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText login;
    EditText password;
    Button button;
    TextView singup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        button = findViewById(R.id.button);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        singup = findViewById(R.id.singup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { show_menu();}
        });
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { show_singup();}
        });
    }
    void show_singup() {
        startActivity(new Intent(this, SignUpActivity.class));
    }
    void show_menu() {
        startActivity(new Intent(this, MenuActivity.class));
    }
}