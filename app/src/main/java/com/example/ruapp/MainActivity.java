package com.example.ruapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ruapp.ADMPackage.RegisterMenuActivity;
import com.example.ruapp.ADMPackage.RegisterRequestActivity;

public class MainActivity extends AppCompatActivity {

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButtonID);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proxTela = new Intent(MainActivity.this, RegisterRequestActivity.class);
                startActivity(proxTela);
            }
        });
    }
}
