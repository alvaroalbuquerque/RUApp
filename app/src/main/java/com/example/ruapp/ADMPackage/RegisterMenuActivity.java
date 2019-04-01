package com.example.ruapp.ADMPackage;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.ruapp.ADMPackage.RegisterMenuPackage.DatePickerFragment;
import com.example.ruapp.ADMPackage.RegisterMenuPackage.MondayRegisterActivity;
import com.example.ruapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegisterMenuActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_menu);
        Intent currentIntent = getIntent();
        Button buttonPickDate = findViewById(R.id.buttonID);
        Button buttonNext = findViewById(R.id.button2);

        buttonPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //VER SE UMA DATA APROPRIADA FOI SELECIONADA
                //CHAMAR AGENDAR SEGUNDA FEIRA
                Intent nextActivity = new Intent(RegisterMenuActivity.this, MondayRegisterActivity.class);
                startActivity(nextActivity);
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM");
        String currentDateString = dt.format(c.getTime());

        TextView textView = findViewById(R.id.textViewID);
        textView.setText(currentDateString);

    }
}
