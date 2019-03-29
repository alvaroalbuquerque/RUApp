package com.example.ruapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class SeeMenuActivity extends AppCompatActivity {

    private ViewPager nSlideViewPager;
   // private LinearLayout nDotLayout;
    private SliderAdapter nSliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_menu);
        Intent intentAtual = getIntent();

        if(intentAtual != null) {

            nSlideViewPager = findViewById(R.id.viewPagerID);
            //nDotLayout = findViewById(R.id.linearLayoutID);
            nSliderAdapter = new SliderAdapter(this);
            nSlideViewPager.setAdapter(nSliderAdapter);
        }

    }
}
