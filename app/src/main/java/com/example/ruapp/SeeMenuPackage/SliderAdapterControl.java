package com.example.ruapp.SeeMenuPackage;

import com.example.ruapp.R;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapterControl {

    public void settingLargeVIewModel(List<LargeViewModel> largeViewModelsLunch, List<LargeViewModel> largeViewModelsDinner){
        //use DB to get de values
        List<ItemModel> itens = new ArrayList<>();
        itens.add(new ItemModel(0,"aaaa",123));
        itens.add(new ItemModel(1,"abb",133));
        itens.add(new ItemModel(2,"ca",423));

        largeViewModelsLunch.add(new LargeViewModel(0,itens,R.drawable.meat_icon));
        largeViewModelsLunch.add(new LargeViewModel(1,itens,R.drawable.vegetarian_icon));
        largeViewModelsLunch.add(new LargeViewModel(2,itens,R.drawable.food_icon));
        largeViewModelsLunch.add(new LargeViewModel(3,itens,R.drawable.juice_icon));
        largeViewModelsLunch.add(new LargeViewModel(4,itens,R.drawable.fruit_icon));/*
        largeViewModelsLunch.get(0).setPic(R.drawable.meat_icon);
        largeViewModelsLunch.get(1).setPic(R.drawable.vegetarian_icon);
        largeViewModelsLunch.get(2).setPic(R.drawable.food_icon);
        largeViewModelsLunch.get(3).setPic(R.drawable.juice_icon);
        largeViewModelsLunch.get(4).setPic(R.drawable.fruit_icon);*/

        largeViewModelsDinner.add(new LargeViewModel(largeViewModelsDinner.size(),itens,R.drawable.food_icon));
        largeViewModelsDinner.add(new LargeViewModel(largeViewModelsDinner.size(),itens,R.drawable.dinner_icon));
        largeViewModelsDinner.add(new LargeViewModel(largeViewModelsDinner.size(),itens,R.drawable.pie_icon));
        largeViewModelsDinner.add(new LargeViewModel(largeViewModelsDinner.size(),itens,R.drawable.juice_icon));
        largeViewModelsDinner.add(new LargeViewModel(largeViewModelsDinner.size(),itens,R.drawable.vegetarian_icon));
        /*
        largeViewModelsDinner.get(0).setPic(R.drawable.food_icon);
        largeViewModelsDinner.get(1).setPic(R.drawable.dinner_icon);
        largeViewModelsDinner.get(2).setPic(R.drawable.pie_icon);
        largeViewModelsDinner.get(3).setPic(R.drawable.juice_icon);
        largeViewModelsDinner.get(4).setPic(R.drawable.vegetarian_icon);*/
    }

    public void settingLargeVIewModelMatrix(LargeViewModel largeViewModelsMatrix[][]){
        //use DB to get de values
        List<ItemModel> itens = new ArrayList<>();
        itens.add(new ItemModel(0,"aaaa",123));
        itens.add(new ItemModel(1,"abb",133));
        itens.add(new ItemModel(2,"ca",423));
        largeViewModelsMatrix[0][0].setPic(R.drawable.meat_icon);
        largeViewModelsMatrix[0][0].setItems(itens);
        largeViewModelsMatrix[0][1].setPic(R.drawable.vegetarian_icon);
        largeViewModelsMatrix[0][1].setItems(itens);
        largeViewModelsMatrix[0][2].setPic(R.drawable.food_icon);
        largeViewModelsMatrix[0][2].setItems(itens);
        largeViewModelsMatrix[0][3].setPic(R.drawable.juice_icon);
        largeViewModelsMatrix[0][3].setItems(itens);
        largeViewModelsMatrix[0][4].setPic(R.drawable.fruit_icon);
        largeViewModelsMatrix[0][4].setItems(itens);

        largeViewModelsMatrix[1][0].setPic(R.drawable.food_icon);
        largeViewModelsMatrix[1][0].setItems(itens);
        largeViewModelsMatrix[1][1].setPic(R.drawable.dinner_icon);
        largeViewModelsMatrix[1][1].setItems(itens);
        largeViewModelsMatrix[1][2].setPic(R.drawable.pie_icon);
        largeViewModelsMatrix[1][2].setItems(itens);
        largeViewModelsMatrix[1][3].setPic(R.drawable.juice_icon);
        largeViewModelsMatrix[1][3].setItems(itens);
        largeViewModelsMatrix[1][4].setPic(R.drawable.vegetarian_icon);
        largeViewModelsMatrix[1][4].setItems(itens);
    }
}
