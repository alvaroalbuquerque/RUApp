package com.example.ruapp.SeeMenuPackage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.ruapp.R;

import java.util.List;

public class MyLargeListAdapter extends BaseAdapter {
    //LargeViewModel largeViewModelList[];
    List<LargeViewModel> largeViewModelList;
    Activity activity;

    public MyLargeListAdapter(List<LargeViewModel> largeViewModelList, Activity activity) {
        this.largeViewModelList = largeViewModelList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return largeViewModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return largeViewModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return largeViewModelList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.activity_list_view2,parent,false);

        List<ItemModel> itens = largeViewModelList.get(position).getItems();
        Integer pic = largeViewModelList.get(position).getPic();

        ImageView picView = view.findViewById(R.id.imageView);
        ListView miniListView = view.findViewById(R.id.listViewLarge);
        miniListView.setDivider(null);
        MyListAdapter meuListAdapter = new MyListAdapter(itens, activity);
        miniListView.setAdapter(meuListAdapter);
        picView.setImageDrawable(activity.getResources().getDrawable(pic));
        return view;
    }
}
