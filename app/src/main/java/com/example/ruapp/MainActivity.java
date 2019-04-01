package com.example.ruapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruapp.ADMPackage.AdminMainActivity;
import com.example.ruapp.ADMPackage.RegisterMenuActivity;
import com.example.ruapp.ADMPackage.RegisterRequestActivity;
import com.example.ruapp.USERPackage.UserMainActivity;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    TextView registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FAZER LOGIN
                Intent proxTela = new Intent(MainActivity.this, UserMainActivity.class);
                startActivity(proxTela);
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerActivity = new Intent(MainActivity.this,RegisterStudentActivity.class);
                startActivity(registerActivity);
            }
        });
    }

    private void initView() {
        loginButton = findViewById(R.id.loginButtonID);
        registerButton = findViewById(R.id.registerViewID);
    }
}
