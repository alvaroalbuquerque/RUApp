package com.example.ruapp.ADMPackage.RegisterMenuPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruapp.ADMPackage.AdminMainActivity;
import com.example.ruapp.ADMPackage.RegisterMenuActivity;
import com.example.ruapp.R;

public class SaturdayRegisterActivity extends AppCompatActivity {


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

    Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saturday_register);

        initView();
        title.setText("SÁBADO");
        Intent currentIntent = getIntent();
        Bundle bundle = currentIntent.getExtras();

        if(currentIntent != null){
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Pegar os dados e colocar na DB
                    Intent nextActivity = new Intent(SaturdayRegisterActivity.this, AdminMainActivity.class);
                    startActivity(nextActivity);
                    finish();
                }
            });

        }


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

        nextButton = findViewById(R.id.finishButtonID);
    }

}
