package com.example.ruapp.USERPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruapp.R;

public class UserMainActivity extends AppCompatActivity {
    TextView greetingsText;
    Button seeMenuButton;
    Button bookButton;
    ImageView backMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        Intent currentIntent = getIntent();
        initView();
        //PEGAR O NOME DO USER E COLOCAR no TEXT VIEW
        seeMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seeMenuActivity = new Intent(UserMainActivity.this, SeeMenuActivity.class);
                startActivity(seeMenuActivity);
            }
        });
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bookActivity = new Intent(UserMainActivity.this, BookActivity.class);
                startActivity(bookActivity);
            }
        });
    }

    public void initView(){
        greetingsText = findViewById(R.id.textView);
        seeMenuButton = findViewById(R.id.menuButtonID);
        bookButton = findViewById(R.id.menuButtonID2);
        backMenu = findViewById(R.id.backButtonID);
    }
}
