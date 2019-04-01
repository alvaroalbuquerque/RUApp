package com.example.ruapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruapp.Controller.MainActivityController;
import com.example.ruapp.USERPackage.UserMainActivity;

public class MainActivity extends AppCompatActivity {

    EditText loginEditText;
    EditText passwordEditText;
    Button loginButton;
    TextView forgotTextView;
    TextView registerTextView;

    MainActivityController mainActivityController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEditText = findViewById(R.id.loginEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        forgotTextView = findViewById(R.id.forgotTextView);
        registerTextView = findViewById(R.id.registerTextView);

        mainActivityController = new MainActivityController();
    }
}
