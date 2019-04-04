package com.example.ruapp.View.USERPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.ruapp.Controller.BookController;
import com.example.ruapp.R;

public class BookActivity extends AppCompatActivity {

    private Button showCalendarButton;
    private TextView selectedDateTextView;
    private Switch lunchSwitch;
    private Switch dinnerSwitch;
    private Button scheduleThisDayButton;
    private Button unscheduleThisDayButton;

    private BookController bookController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initView();

        showCalendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookController.showDatePickerDialog(selectedDateTextView, scheduleThisDayButton, unscheduleThisDayButton);
            }
        });

        scheduleThisDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedDate = selectedDateTextView.getText().toString();
                boolean lunchSelected = lunchSwitch.isChecked();
                boolean dinnerSelected = dinnerSwitch.isChecked();
                bookController.manageSchedule(selectedDate, lunchSelected, dinnerSelected, true);
            }
        });

        unscheduleThisDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedDate = selectedDateTextView.getText().toString();
                boolean lunchSelected = lunchSwitch.isChecked();
                boolean dinnerSelected = dinnerSwitch.isChecked();
                bookController.manageSchedule(selectedDate, lunchSelected, dinnerSelected, false);
            }
        });
    }

    private void initView() {
        showCalendarButton = findViewById(R.id.showCalendarButton);
        selectedDateTextView = findViewById(R.id.selectedDateTextView);
        lunchSwitch = findViewById(R.id.lunchSwitch);
        dinnerSwitch = findViewById(R.id.dinnerSwitch);
        scheduleThisDayButton = findViewById(R.id.scheduleThisDayButton);
        scheduleThisDayButton.setVisibility(View.INVISIBLE);
        unscheduleThisDayButton = findViewById(R.id.unscheduleThisDayButton);
        unscheduleThisDayButton.setVisibility(View.INVISIBLE);

        bookController = new BookController(this);
    }
}
