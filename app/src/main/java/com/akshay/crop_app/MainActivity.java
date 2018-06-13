package com.akshay.crop_app;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.akshay.crop_app.NavigationItem.Nav1;
import com.akshay.crop_app.services.SplashService;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

import com.akshay.crop_app.NavigationItem.Nav2;
import com.akshay.crop_app.NavigationItem.Nav3;
import com.akshay.crop_app.NavigationItem.Nav4;
import com.akshay.crop_app.menu.DrawerAdapter;
import com.akshay.crop_app.menu.DrawerItem;
import com.akshay.crop_app.menu.SimpleItem;
import com.akshay.crop_app.menu.SpaceItem;

public class MainActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener{

    private SlidingRootNav slidingRootNav;
    private static final int NAV1 = 0;
    private static final int NAV2 = 1;
    private static final int NAV3 = 2;
    private static final int NAV4 = 3;
    private static final int EXIT = 5;

    private String[] screenTitles;
    private Drawable[] screenIcons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button profile=(Button)findViewById(R.id.button1);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"Farming Techniques",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Nav3.class));
            }
        });

        Button education=(Button)findViewById(R.id.button2);
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"Seeds Selection",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Nav4.class));
            }
        });

        Button health=(Button)findViewById(R.id.button3);
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"Krishi Yojnas",Toast.LENGTH_SHORT).show();
            }
        });

        Button goals=(Button)findViewById(R.id.button4);
        goals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"Mandi Rates",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MandiRates.class ));
            }
        });
        goals.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                startActivity(new Intent(MainActivity.this, MandiRateUploader.class));
                return true;
            }
        });

        Button finance=(Button)findViewById(R.id.button5);
        finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"About US",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Nav2.class));
            }
        });

        Button comfort=(Button)findViewById(R.id.button6);
        comfort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"Help Desk", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Help.class));
            }
        });

        //NAVIGATION


        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(true)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter drawadapter = new DrawerAdapter(Arrays.asList(
                createItemFor(NAV1).setChecked(true),
                createItemFor(NAV2),
                createItemFor(NAV3),
                createItemFor(NAV4),
                new SpaceItem(48),
                createItemFor(EXIT)));
        drawadapter.setListener(this);

        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(drawadapter);
        drawadapter.setSelected(NAV1);


    }


    @Override
    public void onItemSelected(int position) {
        if (position == EXIT) {
            startActivity(new Intent(MainActivity.this, SplashService.class));
            Toast.makeText(getApplicationContext(),"User Successfully Logout",Toast.LENGTH_SHORT).show();
        }
        if (position == NAV2

                ) {
            startActivity(new Intent(getApplicationContext(), Nav2.class));
            Toast.makeText(getApplicationContext(),"About US",Toast.LENGTH_SHORT).show();
        }

        if (position == NAV3

                ) {
            Toast.makeText(getApplicationContext(),"Rate App",Toast.LENGTH_SHORT).show();
        }

        if (position == NAV4

                ) {
            Toast.makeText(getApplicationContext(),"Share App",Toast.LENGTH_SHORT).show();

        }

        slidingRootNav.closeMenu();
        // Fragment selectedScreen = CenteredTextFragment.createFor(screenTitles[position]);
        // showFragment(selectedScreen);
    }



    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.offwhile))
                .withTextTint(color(R.color.offwhile))
                .withSelectedIconTint(color(R.color.navfun))
                .withSelectedTextTint(color(R.color.navfun));
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }
    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }

}



