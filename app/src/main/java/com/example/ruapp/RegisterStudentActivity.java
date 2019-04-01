package com.example.ruapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterStudentActivity  extends AppCompatActivity {
    EditText nameText;
    EditText emailText;
    EditText cpfText;
    EditText coleggerRegisterText;
    EditText passwordText;
    EditText password2Text;
    Button confirmButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Intent currentIntent = getIntent();

        initView();
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ADD NO DB_REG_REQ
                finish();
            }
        });
    }

    private void initView() {
        nameText = findViewById(R.id.nameTextID);
        emailText= findViewById(R.id.emailTextID);
        cpfText= findViewById(R.id.sIdTextID);
        coleggerRegisterText = findViewById(R.id.ufalIdTextID);
        passwordText= findViewById(R.id.passwordEditText);
        password2Text= findViewById(R.id.passwordTextID2);
        confirmButton= findViewById(R.id.registerButtonID);
    }
}
