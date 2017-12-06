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
    public String links[] = new String[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.NewPennTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTheme(R.style.backgroundtransparent);

        links[0] = "https://penn.phmschools.org/calendars#Penn High School Public Calendar";
        links[1] = "https://penn.phmschools.org/students-and-parents";
        links[2] = "https://penn.phmschools.org/counseling";
        links[3] = "https://penn.phmschools.org/sports-news/;";
        links[4] = "https://penn.phmschools.org/performing-arts";
        links[5] = "https://penn.phmschools.org/students-and-parents/get-involved/students/clubs";
        links[6] = "https://penn.phmschools.org/";

    }

    public void onClick(View v){
        intent = null;
        char type = v.getTag().toString().charAt(0);
        char target = v.getTag().toString().charAt(1);
        switch(type) {
            case 'a':
                switch (target) {
                    case 'n':
                        intent = new Intent(this, newsActivity.class);
                        break;
                    case 'a':
                        intent = new Intent(this, academicsActivity.class);
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
                startActivity(intent);
                break;
            case 'l':
                int site = v.getTag().toString().charAt(1);
                site -= '0';
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(Color.DKGRAY);
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(this, Uri.parse(links[site]));
                break;
        }




    }
}