package com.akshay.crop_app.NavigationItem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.akshay.crop_app.R;

public class Nav3 extends AppCompatActivity {

    CardView wheat, rice, sugarcane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav3);

        wheat = (CardView) findViewById(R.id.card_wheat_tech);
        rice = (CardView) findViewById(R.id.card_rice_tech);
        sugarcane =(CardView) findViewById(R.id.card_sugarcane_tech);

        wheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Nav3.this, com.akshay.crop_app.crops.wheat_tech.class ));

            }
        });

        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Nav3.this, com.akshay.crop_app.crops.Rice_tech.class ));

            }
        });

        sugarcane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Nav3.this, com.akshay.crop_app.crops.sugarcane_tech.class ));

            }
        });



    }
}
