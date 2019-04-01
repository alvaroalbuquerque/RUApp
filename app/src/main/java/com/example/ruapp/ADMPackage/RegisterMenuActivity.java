package com.example.ruapp.ADMPackage;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ruapp.ADMPackage.RegisterMenuPackage.DatePickerFragment;
import com.example.ruapp.ADMPackage.RegisterMenuPackage.MondayRegisterActivity;
import com.example.ruapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegisterMenuActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    Button buttonPickDate;
    Button buttonNext;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_menu);
        Intent currentIntent = getIntent();
        buttonPickDate = findViewById(R.id.buttonID);
        buttonNext = findViewById(R.id.button2);
        textView = findViewById(R.id.textViewID);

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
        ;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            c.set(Calendar.DAY_OF_WEEK, view.getFirstDayOfWeek());
        }*/
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM - ");
        String currentDateString = dt.format(c.getTime()) + c.get(Calendar.DAY_OF_WEEK);
        if(isDateValid(year, month, dayOfMonth)){
            textView.setText(currentDateString);
        }

        //TextView textView = findViewById(R.id.textViewID);

    }

    public boolean isDateValid(int year, int month, int dayOfMonth){
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        Calendar pickedDate = Calendar.getInstance();
        pickedDate.set(Calendar.YEAR,year);
        pickedDate.set(Calendar.MONTH,month);
        pickedDate.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        if(pickedDate.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
            if(pickedDate.get(Calendar.YEAR) >= currentYear)
            {
                //if (pickedDate.get(Calendar.MONTH) >=)
            }
            return true;
        }else{
            Toast.makeText(RegisterMenuActivity.this,"Invalid Input",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
