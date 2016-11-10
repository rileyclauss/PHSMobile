package com.phsapp.phsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.*;

public class clubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        WebSettings websettings = myWebView.getSettings();
        websettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://penn.phmschools.org/students-and-parents/get-involved/students");

    }




}
