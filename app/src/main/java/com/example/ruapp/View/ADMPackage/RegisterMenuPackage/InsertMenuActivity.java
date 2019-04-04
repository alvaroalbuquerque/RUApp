package com.example.ruapp.View.ADMPackage.RegisterMenuPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruapp.Controller.InsertMenuController;
import com.example.ruapp.Model.MenuDinnerModel;
import com.example.ruapp.Model.MenuLunchModel;
import com.example.ruapp.R;

public class InsertMenuActivity extends AppCompatActivity {

    Button showCalendarButton;
    TextView selectedDateTextView;
    Button sendMenuButton;

    TextView textSubTitleViewID;
    TextView textSubTitle1ViewID;

    EditText protein1EditText;
    EditText protein2EditText;
    EditText vegetarianEditText;
    EditText riceEditText;
    EditText beanEditText;
    EditText food3EditText;
    EditText saladEditText;
    EditText juiceEditText;
    EditText fruitEditText;
    
    EditText soupEditText;
    EditText maindish1EditText;
    EditText maindish2EditText;
    EditText maindish3EditText;
    EditText piesEditText;
    EditText cakesEditText;
    EditText drinkEditText;
    EditText veg1EditText;
    EditText veg2EditText;
    EditText veg3EditText;
    
    InsertMenuController insertMenuController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday_register);

        initView();

        showCalendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertMenuController.showDatePickerDialog(selectedDateTextView, InsertMenuActivity.this);
            }
        });

        sendMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String protein1 = protein1EditText.getText().toString();
                String protein2 = protein2EditText.getText().toString();
                String vegetarian = vegetarianEditText.getText().toString();
                String rice = riceEditText.getText().toString();
                String bean = beanEditText.getText().toString();
                String food3 = food3EditText.getText().toString();
                String salad = saladEditText.getText().toString();
                String juice = juiceEditText.getText().toString();
                String fruit = fruitEditText.getText().toString();

                MenuLunchModel menuLunch = new MenuLunchModel.MenuModelBuilder().
                        setProtein1(protein1).
                        setProtein2(protein2).
                        setVegetarian(vegetarian).
                        setRice(rice).
                        setBean(bean).
                        setFood3(food3).
                        setSalad(salad).
                        setJuice(juice).
                        setFruit(fruit).
                        build();

                String soup = soupEditText.getText().toString();
                String maindish1 = maindish1EditText.getText().toString();
                String maindish2 = maindish2EditText.getText().toString();
                String maindish3 = maindish3EditText.getText().toString();
                String pies = piesEditText.getText().toString();
                String cakes = cakesEditText.getText().toString();
                String drink = drinkEditText.getText().toString();
                String veg1 = veg1EditText.getText().toString();
                String veg2 = veg2EditText.getText().toString();
                String veg3 = veg3EditText.getText().toString();

                MenuDinnerModel menuDinner = new MenuDinnerModel.MenuModelBuilder().
                        setSoup(soup)
                        .setMaindish1(maindish1)
                        .setMaindish2(maindish2)
                        .setMaindish3(maindish3)
                        .setPies(pies)
                        .setCakes(cakes)
                        .setDrink(drink)
                        .setVeg1(veg1)
                        .setVeg2(veg2)
                        .setVeg3(veg3)
                        .build();

                Log.i("CORNOLIZO: ", menuDinner.toString());

                String selectedDate = selectedDateTextView.getText().toString();

                boolean b1 = !(textSubTitle1ViewID.getVisibility() == View.GONE);
                boolean b2 = !(textSubTitleViewID.getVisibility() == View.GONE);

                insertMenuController.insertMenu(selectedDate, menuLunch, menuDinner, b1, b2);
            }
        });
    }

    private void initView() {
        textSubTitleViewID = findViewById(R.id.textSubTitleViewID);
        textSubTitle1ViewID = findViewById(R.id.textSubTitle1ViewID);

        showCalendarButton = findViewById(R.id.showCalendarButton);
        selectedDateTextView = findViewById(R.id.selectedDateTextView);
        sendMenuButton = findViewById(R.id.sendMenuButton);

        protein1EditText = findViewById(R.id.protein1EditText);
        protein2EditText = findViewById(R.id.protein2EditText);
        vegetarianEditText = findViewById(R.id.vegetarianEditText);
        riceEditText = findViewById(R.id.riceEditText);
        beanEditText = findViewById(R.id.beanEditText);
        food3EditText = findViewById(R.id.food3EditText);
        saladEditText = findViewById(R.id.saladEditText);
        juiceEditText = findViewById(R.id.juiceEditText);
        fruitEditText = findViewById(R.id.fruitEditText);

        soupEditText = findViewById(R.id.soupEditText);
        maindish1EditText = findViewById(R.id.maindish1EditText);
        maindish2EditText = findViewById(R.id.maindish2EditText);
        maindish3EditText = findViewById(R.id.maindish3EditText);
        piesEditText = findViewById(R.id.piesEditText);
        cakesEditText = findViewById(R.id.cakesEditText);
        drinkEditText = findViewById(R.id.drinkEditText);
        veg1EditText = findViewById(R.id.veg1EditText);
        veg2EditText = findViewById(R.id.veg2EditText);
        veg3EditText = findViewById(R.id.veg3EditText);

        insertMenuController = new InsertMenuController(this);

        goneLunchViews(View.GONE);
        goneDinnerViews(View.GONE);
    }

    public void goneLunchViews(int flag) {
        textSubTitle1ViewID.setVisibility(flag);
        findViewById(R.id.proteinViewID).setVisibility(flag);
        protein1EditText.setVisibility(flag);
        protein2EditText.setVisibility(flag);
        findViewById(R.id.vegLunchViewID).setVisibility(flag);
        vegetarianEditText.setVisibility(flag);
        findViewById(R.id.riceViewID).setVisibility(flag);
        riceEditText.setVisibility(flag);
        findViewById(R.id.beanViewID).setVisibility(flag);
        beanEditText.setVisibility(flag);
        findViewById(R.id.food3ViewID).setVisibility(flag);
        food3EditText.setVisibility(flag);
        findViewById(R.id.saladViewID).setVisibility(flag);
        saladEditText.setVisibility(flag);
        findViewById(R.id.juiceViewID).setVisibility(flag);
        juiceEditText.setVisibility(flag);
        findViewById(R.id.fruitViewID).setVisibility(flag);
        fruitEditText.setVisibility(flag);
    }

    public void goneDinnerViews(int flag) {
        textSubTitleViewID.setVisibility(flag);
        findViewById(R.id.soupViewID).setVisibility(flag);
        soupEditText.setVisibility(flag);
        findViewById(R.id.mainDishViewID).setVisibility(flag);
        maindish1EditText.setVisibility(flag);
        maindish2EditText.setVisibility(flag);
        maindish3EditText.setVisibility(flag);
        findViewById(R.id.piesViewID).setVisibility(flag);
        piesEditText.setVisibility(flag);
        findViewById(R.id.cakesViewID).setVisibility(flag);
        cakesEditText.setVisibility(flag);
        findViewById(R.id.drinkViewID).setVisibility(flag);
        drinkEditText.setVisibility(flag);
        findViewById(R.id.vegDinnerViewID).setVisibility(flag);
        veg1EditText.setVisibility(flag);
        veg2EditText.setVisibility(flag);
        veg3EditText.setVisibility(flag);
    }
}
