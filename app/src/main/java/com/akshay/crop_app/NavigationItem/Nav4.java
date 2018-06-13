package com.akshay.crop_app.NavigationItem;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.akshay.crop_app.R;

public class Nav4 extends AppCompatActivity {

    CardView wheat, makka, bajra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav4);

        wheat =(CardView)findViewById(R.id.card_wheat_seeds);
        makka = (CardView) findViewById(R.id.card_maize_seeds);
        bajra = (CardView)findViewById(R.id.card_bajra_seeds);

        wheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startActivity(new Intent(Nav4.this, com.akshay.crop_app.seeds.wheat_seeds.class));
            }
        });

        makka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Nav4.this, com.akshay.crop_app.seeds.maize_seeds.class));
            }
        });

        bajra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Nav4.this, com.akshay.crop_app.seeds.bajra_seeds.class));
            }
        });
    }
}
