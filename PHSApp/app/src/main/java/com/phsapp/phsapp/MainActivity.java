package com.phsapp.phsapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.NewPennTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTheme(R.style.backgroundtransparent);
    }

    public void onClick(View v){
        intent = null;
        char target = v.getTag().toString().charAt(0);
        switch (target){
            case 'n':
               intent =  new Intent(this, newsActivity.class);
                break;
            case 'c':
                intent = new Intent(this, calendarActivity.class);
                break;
            case 'y':
               intent = new Intent(this, sapActivity.class);
                break;
            case 'a':
                intent = new Intent(this, academicsActivity.class);
                break;
            case 'o':
                intent = new Intent(this, counselingActivity.class);
                break;
            case 't':
                intent = new Intent(this, athleticsActivity.class);
                break;
            case 'f':
                intent = new Intent(this, fineartsActivity.class);
                break;
            case 'l':
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(Color.DKGRAY);
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(this, Uri.parse("https://penn.phmschools.org/students-and-parents/get-involved/students/clubs"));
                break;
            case 'p':
                intent = new Intent(this, photogalleryActivity.class);
                break;
            case 'u':
                intent = new Intent(this, aboutActivity.class);
                break;
            case 'x':
                intent = new Intent(this, contactActivity.class);
                break;
            // Need a case for staff links
        }
        if(target !='l'){startActivity(intent);}

    }
}