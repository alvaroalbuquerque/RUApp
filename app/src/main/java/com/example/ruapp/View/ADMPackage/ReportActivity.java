package com.example.ruapp.View.ADMPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruapp.Controller.ReportController;
import com.example.ruapp.R;

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

        initView();

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

    private void initView() {
        selDate = findViewById(R.id.selDate);
        dateButton = findViewById(R.id.dateButton);
        lunRel = findViewById(R.id.lunchRel);
        dinnerRel = findViewById(R.id.dinnerRel);
        backButton = findViewById(R.id.backButton);
    }
}
