package com.example.ruapp.View.USERPackage.SeeMenuPackage;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ruapp.Controller.SliderAdapterController;
import com.example.ruapp.R;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends PagerAdapter {
    List<LargeViewModel> largeViewModelsLunch;
    List<LargeViewModel> largeViewModelsDinner;

    Context context;
    LayoutInflater layoutInflater;

    SliderAdapterController sliderAdapterController;

    public SliderAdapter(Context context){
        this.context = context;
        sliderAdapterController = new SliderAdapterController(context);
        largeViewModelsLunch = new ArrayList<>();
        largeViewModelsDinner = new ArrayList<>();
        sliderAdapterController.settingLargeVIewModel(largeViewModelsLunch,largeViewModelsDinner);

    }

    public String[] slide_titles = {"ALMOÇO", "JANTAR"};

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

        List<LargeViewModel> largeViewModelsThisShift;
        if(position == 0){
            largeViewModelsThisShift = largeViewModelsLunch;
        }else{
            largeViewModelsThisShift = largeViewModelsDinner;
        }
        TextView slideTitleText = view.findViewById(R.id.slideTitleTextID);
        ListView largeListView = view.findViewById(R.id.slideLargeListViewID);
        largeListView.setVerticalScrollBarEnabled(false);
        MyLargeListAdapter myLargeListAdapter = new MyLargeListAdapter(largeViewModelsThisShift,(Activity)context);
        largeListView.setAdapter(myLargeListAdapter);

        slideTitleText.setText(slide_titles[position]); //position é uma variavel do pager adapter

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
