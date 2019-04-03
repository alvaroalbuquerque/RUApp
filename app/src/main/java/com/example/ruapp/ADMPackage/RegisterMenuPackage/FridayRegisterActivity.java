package com.example.ruapp.ADMPackage.RegisterMenuPackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruapp.R;

public class FridayRegisterActivity extends AppCompatActivity {
    TextView title;
    TextView subTitle1;
    TextView proteinView;
    EditText proteinText1;
    EditText proteinText2;
    TextView vegLunchView;
    EditText vegLunchText;
    TextView riceView;
    EditText riceText;
    TextView beanView;
    EditText beanText;
    TextView food3View;
    EditText food3Text;
    TextView saladView;
    EditText saladText;
    TextView juiceView;
    EditText juiceText;
    TextView fruitView;
    EditText fruitText;
    TextView soupView;
    EditText soupText;
    TextView mainDishView;
    EditText mainDishText;
    EditText mainDishText2;
    EditText mainDishText3;
    TextView piesView;
    EditText piesText;
    TextView cakesView;
    EditText cakesText;
    TextView drinkView;
    EditText drinkText;
    TextView vegDinnerView;
    EditText vegDinnerText;
    EditText vegDinnerText2;
    EditText vegDinnerText3;

    Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday_register);
        Intent currentIntent = getIntent();

        initView();
        title.setText("SEXTA-FEIRA");

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pegar os dados e colocar na DB

                Intent nextActivity = new Intent(FridayRegisterActivity.this,SaturdayRegisterActivity.class);
                startActivity(nextActivity);
                finish();
            }
        });
    }

    public void initView(){
        title = findViewById(R.id.textTitleViewID);
        subTitle1 = findViewById(R.id.textSubTitle1ViewID);
        proteinView   = findViewById(R.id.proteinViewID);
        proteinText1  = findViewById(R.id.protein1EditText);
        proteinText2  = findViewById(R.id.protein2EditText);
        vegLunchView  = findViewById(R.id.vegLunchViewID);
        vegLunchText  = findViewById(R.id.vegetarianEditText);
        riceView  = findViewById(R.id.riceViewID);
        riceText  = findViewById(R.id.riceEditText);
        beanView  = findViewById(R.id.beanViewID);
        beanText  = findViewById(R.id.beanEditText);
        food3View  = findViewById(R.id.food3ViewID);
        food3Text  = findViewById(R.id.food3EditText);
        saladView  = findViewById(R.id.saladViewID);
        saladText  = findViewById(R.id.saladEditText);
        juiceView  = findViewById(R.id.juiceViewID);
        juiceText  = findViewById(R.id.juiceEditText);
        fruitView  = findViewById(R.id.fruitViewID);
        fruitText  = findViewById(R.id.fruitEditText);
        soupView  = findViewById(R.id.soupViewID);
        soupText  = findViewById(R.id.soupEditText);
        mainDishView  = findViewById(R.id.mainDishViewID);
        mainDishText  = findViewById(R.id.maindish1EditText);
        mainDishText2  = findViewById(R.id.maindish2EditText);
        mainDishText3  = findViewById(R.id.maindish3EditText);
        piesView   = findViewById(R.id.piesViewID);
        piesText  = findViewById(R.id.piesEditText);
        cakesView  = findViewById(R.id.cakesViewID);
        cakesText  = findViewById(R.id.cakesEditText);
        drinkView  = findViewById(R.id.drinkViewID);
        drinkText  = findViewById(R.id.drinkEditText);
        vegDinnerView  = findViewById(R.id.vegDinnerViewID);
        vegDinnerText  = findViewById(R.id.veg1EditText);
        vegDinnerText2  = findViewById(R.id.veg2EditText);
        vegDinnerText3  = findViewById(R.id.veg3EditText);

        //nextButton = findViewById(R.id.nextButtonID);
    }
}
