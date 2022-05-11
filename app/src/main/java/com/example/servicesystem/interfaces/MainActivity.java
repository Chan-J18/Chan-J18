package com.example.servicesystem.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.servicesystem.R;

import user.interfaces.UserActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLogin,btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.main_btn_login);
        btnRegister = findViewById(R.id.main_btn_register);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.main_btn_login:
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
                break;
            case R.id.main_btn_register:
                break;
        }
    }
}