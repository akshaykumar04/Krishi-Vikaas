package com.akshay.crop_app.services;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.akshay.crop_app.OTP;
import com.akshay.crop_app.R;

public class SplashService extends AppCompatActivity {
    //private static int SPLASH_TIME_OUT=2000;

    CardView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        signup = (CardView) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(SplashService.this, OTP.class));
            }
        });

    }
}
