package com.example.ruapp.View.USERPackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.ruapp.R;
import com.example.ruapp.View.USERPackage.SeeMenuPackage.SliderAdapter;

public class SeeMenuActivity extends AppCompatActivity {

    private ViewPager nSlideViewPager;
    private SliderAdapter nSliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_menu);
        Intent intentAtual = getIntent();

        if(intentAtual != null) {

            nSlideViewPager = findViewById(R.id.viewPagerID);
            nSliderAdapter = new SliderAdapter(this);
            nSlideViewPager.setAdapter(nSliderAdapter);
        }

    }
}
