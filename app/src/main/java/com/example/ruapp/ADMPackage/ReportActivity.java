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
import android.widget.Toast;

import com.example.ruapp.ADMPackage.RegisterMenuPackage.DatePickerFragment;
import com.example.ruapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    Button datePickerButton;
    Button backButton;
    TextView dataView;
    TextView countView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Intent intent = getIntent();
        initView();

        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
                //BUSCA A QUANTIDADE DE PESSOAS E ESCREVE NA countView
                int count = 0;
                countView.setText("Total de Agendamentos: " + Integer.toString(count));
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public void initView(){
        datePickerButton = findViewById(R.id.dateButton);
        backButton = findViewById(R.id.backButton);
        dataView = findViewById(R.id.textView6);
        countView = findViewById(R.id.textView7);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM");
        String currentDateString = dt.format(c.getTime());
        if(isDateValid(year, month, dayOfMonth)){
            dataView.setText(currentDateString);
        }

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

        if(pickedDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
            if(pickedDate.get(Calendar.YEAR) >= currentYear)
            {
                //if (pickedDate.get(Calendar.MONTH) >=)
            }
            return true;
        }else{
            Toast.makeText(ReportActivity.this,"Invalid Input",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
