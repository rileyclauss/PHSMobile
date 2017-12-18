package com.phsapp.phsapp;


import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;



public class customTab extends AppCompatActivity {
    public static void openTab(Context cont, String url){
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(Color.DKGRAY);
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(cont, Uri.parse(url));
    }
}
