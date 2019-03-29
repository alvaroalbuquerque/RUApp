package com.example.ruapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public String[] slide_titles = {"ALMOÇO", "JANTAR"};
    public String[] slide_subtitles1 = {"Proteína:", "Sopa:"};
    public String[] slide_subtitles2 = {"Vegetariano:", "Prato do Dia:"};
    public String[] slide_subtitles3 = {"Feijão:", "Torta:"};

    @Override
    public int getCount() {
        return slide_titles.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_see_menu_slide_layout, null);

        TextView slideTitleText = view.findViewById(R.id.slideTitleTextID);
        TextView textFirstView = view.findViewById(R.id.textFirstViewID);
        TextView textSecondView = view.findViewById(R.id.textSecondViewID);
        TextView textThirdView = view.findViewById(R.id.textThirdViewID);

        slideTitleText.setText(slide_titles[position]); //position é uma variavel do pager adapter
        textFirstView.setText(slide_subtitles1[position]);
        textSecondView.setText(slide_subtitles2[position]);
        textThirdView.setText(slide_subtitles3[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
