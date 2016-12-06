package com.phsapp.phsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.*;
import android.webkit.*;

public class newsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        final pl.droidsonroids.gif.GifTextView loading = (pl.droidsonroids.gif.GifTextView) findViewById(R.id.load);
        final WebView myWebView = (WebView) findViewById(R.id.webview1);
        final TextView ltext = (TextView) findViewById(R.id.textView);
        myWebView.setVisibility(View.INVISIBLE);
        WebSettings websettings = myWebView.getSettings();
        websettings.setJavaScriptEnabled(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("https://penn.phmschools.org/news");
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                loading.setVisibility(View.INVISIBLE);
                ltext.setVisibility(View.INVISIBLE);
                myWebView.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByID('main-header')[0];"
                        + "head.parentNode.removeChild(head);"+
                        "})()");
                myWebView.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByTagName('main-footer')[0];"
                        + "head.parentNode.removeChild(head);"+
                        "})()");
                myWebView.setVisibility(View.VISIBLE);
            }
        });
    }




}
