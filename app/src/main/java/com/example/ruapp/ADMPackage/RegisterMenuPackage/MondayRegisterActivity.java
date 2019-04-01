package com.example.ruapp.ADMPackage.RegisterMenuPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruapp.R;

public class MondayRegisterActivity extends AppCompatActivity {
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
        title.setText("SEGUNDA-FEIRA");

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pegar os dados e colocar na DB

                Intent nextActivity = new Intent(MondayRegisterActivity.this,TuesdayRegisterActivity.class);
                startActivity(nextActivity);
                finish();
            }
        });
    }

    public void initView(){
        title = findViewById(R.id.textTitleViewID);
        subTitle1 = findViewById(R.id.textSubTitle1ViewID);
        proteinView   = findViewById(R.id.proteinViewID);
        proteinText1  = findViewById(R.id.editProteinTextID);
        proteinText2  = findViewById(R.id.editProtein2TextID);
        vegLunchView  = findViewById(R.id.vegLunchViewID);
        vegLunchText  = findViewById(R.id.editVegLunchTextID);
        riceView  = findViewById(R.id.riceViewID);
        riceText  = findViewById(R.id.editRiceTextID);
        beanView  = findViewById(R.id.beanViewID);
        beanText  = findViewById(R.id.editBeanTextID);
        food3View  = findViewById(R.id.food3ViewID);
        food3Text  = findViewById(R.id.editFood3TextID);
        saladView  = findViewById(R.id.saladViewID);
        saladText  = findViewById(R.id.editSaladTextID);
        juiceView  = findViewById(R.id.juiceViewID);
        juiceText  = findViewById(R.id.editJuiceTextID);
        fruitView  = findViewById(R.id.fruitViewID);
        fruitText  = findViewById(R.id.editFruitTextID);
        soupView  = findViewById(R.id.soupViewID);
        soupText  = findViewById(R.id.editSoupTextID);
        mainDishView  = findViewById(R.id.mainDishViewID);
        mainDishText  = findViewById(R.id.editMainDishTextID);
        mainDishText2  = findViewById(R.id.editMainDish2TextID);
        mainDishText3  = findViewById(R.id.editMainDish3TextID);
        piesView   = findViewById(R.id.piesViewID);
        piesText  = findViewById(R.id.editPiesTextID);
        cakesView  = findViewById(R.id.cakesViewID);
        cakesText  = findViewById(R.id.editCakesTextID);
        drinkView  = findViewById(R.id.drinkViewID);
        drinkText  = findViewById(R.id.editDrinkTextID);
        vegDinnerView  = findViewById(R.id.vegDinnerViewID);
        vegDinnerText  = findViewById(R.id.editVegDinnerTextID);
        vegDinnerText2  = findViewById(R.id.editVegDinner2TextID);
        vegDinnerText3  = findViewById(R.id.editVegDinner3TextID);

        nextButton = findViewById(R.id.nextButtonID);
    }
}
