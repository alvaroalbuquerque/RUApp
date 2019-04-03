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
import com.example.ruapp.Controller.ReportController;
import com.example.ruapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportActivity extends AppCompatActivity {
    TextView selDate;
    Button dateButton;
    TextView lunRel;
    TextView dinnerRel;
    Button backButton;

    ReportController reportController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        selDate = findViewById(R.id.selDate);
        dateButton = findViewById(R.id.dateButton);
        lunRel = findViewById(R.id.lunchRel);
        dinnerRel = findViewById(R.id.dinnerRel);
        backButton = findViewById(R.id.backButton);

        reportController = new ReportController(this);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reportController.showDatePickerDialog(selDate, lunRel, dinnerRel);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
