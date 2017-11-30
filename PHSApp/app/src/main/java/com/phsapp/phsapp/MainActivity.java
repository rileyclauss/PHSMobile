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
        String url = null;
        switch (target){
            case 'n':
               intent =  new Intent(this, newsActivity.class);
                break;
            case 'c':
                url = "https://penn.phmschools.org/calendars";
                break;
            case 'y':
                url = "https://penn.phmschools.org/students-and-parents";
                break;
            case 'a':
                intent = new Intent(this, academicsActivity.class);
                break;
            case 'o':
                intent = new Intent(this, counselingActivity.class);
                break;
            case 't':
                url = "https://penn.phmschools.org/sports-news/";
                break;
            case 'f':
                url = "https://penn.phmschools.org/performing-arts";
                break;
            case 'l':
                url = "https://penn.phmschools.org/students-and-parents/get-involved/students/clubs";
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
            case 'z':
                intent = new Intent(this, staffActivity.class);
                break;
        }
        if (target == 'l' || target == 'c' || target == 't' || target == 'f' || target == 'y') {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            builder.setToolbarColor(Color.DKGRAY);
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(this, Uri.parse(url));
        }

        else {
            startActivity(intent);
        }

    }
}