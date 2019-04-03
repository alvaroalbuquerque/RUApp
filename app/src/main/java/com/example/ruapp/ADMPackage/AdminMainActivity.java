package com.example.ruapp.ADMPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruapp.ADMPackage.RegisterMenuPackage.InsertMenuActivity;
import com.example.ruapp.R;

public class AdminMainActivity extends AppCompatActivity {
    TextView title;
    Button regReqButton;
    Button addMenuButton;
    Button seeReportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        Intent currentIntent = getIntent();
        initView();

        regReqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerRequestActivity = new Intent(AdminMainActivity.this,RegisterRequestActivity.class);
                startActivity(registerRequestActivity);

            }
        });

        addMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerMenuActivity = new Intent(AdminMainActivity.this, InsertMenuActivity.class);
                startActivity(registerMenuActivity);
            }
        });

        seeReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seeReportActivity = new Intent(AdminMainActivity.this,ReportActivity.class);
                startActivity(seeReportActivity);
            }
        });
    }

    private void initView(){
        title = findViewById(R.id.textView3);
        regReqButton = findViewById(R.id.buttonRegID);
        addMenuButton = findViewById(R.id.buttonMenuID);
        seeReportButton = findViewById(R.id.buttonMenuID2);
    }
}
