package com.akshay.crop_app.NavigationItem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.akshay.crop_app.R;

public class Nav2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
