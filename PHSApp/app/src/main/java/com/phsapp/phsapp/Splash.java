package com.phsapp.phsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.content.Intent;

public class Splash extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        int secondsDelayed = 2000;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Splash.this, MainActivity.class));
                finish();
            }
        }, secondsDelayed);
    }
}