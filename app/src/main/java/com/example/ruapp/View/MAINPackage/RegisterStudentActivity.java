package com.example.ruapp.View.MAINPackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ruapp.Controller.RegisterStudentController;
import com.example.ruapp.Model.Student;
import com.example.ruapp.R;

public class RegisterStudentActivity  extends AppCompatActivity {
    EditText nameEditText;
    EditText emailEditText;
    EditText cpfEditText;
    EditText collegeRegisterEditText;
    EditText passwordEditText;
    EditText confirmPasswordEditText;
    Button requestRegisterButton;

    RegisterStudentController registerStudentController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();

        requestRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameInput = nameEditText.getText().toString();
                String emailInput = emailEditText.getText().toString();
                String cpfInput = cpfEditText.getText().toString();
                String collegeRegisterInput = collegeRegisterEditText.getText().toString();
                String passwordInput = passwordEditText.getText().toString();
                String confirmPasswordInput = confirmPasswordEditText.getText().toString();

                Student newStudent = new Student(nameInput, emailInput, cpfInput, collegeRegisterInput, passwordInput);

                registerStudentController.resquestRegistration(newStudent, confirmPasswordInput);
            }
        });
    }

    private void initView() {
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        cpfEditText = findViewById(R.id.cpfEditText);
        collegeRegisterEditText = findViewById(R.id.collegeRegisterEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        requestRegisterButton = findViewById(R.id.requestRegisterButton);

        registerStudentController = new RegisterStudentController(this);
    }
}
