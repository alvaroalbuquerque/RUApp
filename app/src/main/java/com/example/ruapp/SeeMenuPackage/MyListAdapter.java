package com.example.ruapp.SeeMenuPackage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ruapp.R;

import java.util.List;

public class MyListAdapter extends BaseAdapter {
    private final List<ItemModel> itens;
    Activity activity;

    public MyListAdapter(List<ItemModel> itens, Activity activity) {
        this.itens = itens;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itens.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.activity_list_view1,parent,false);
        ItemModel item = itens.get(position);

        TextView nome = view.findViewById(R.id.nameViewListID);
        TextView calorie = view.findViewById(R.id.calorieViewListID);

        nome.setText(item.getNome());
        calorie.setText(String.valueOf(item.getCal()));

        return view;
    }
}
