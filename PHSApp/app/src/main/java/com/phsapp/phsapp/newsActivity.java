package com.phsapp.phsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.*;

public class newsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        final WebView myWebView = (WebView) findViewById(R.id.webview2);
        WebSettings websettings = myWebView.getSettings();
        websettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        final WebView webview = (WebView)findViewById(R.id.webview2);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url)
            {
                myWebView.loadUrl("javascript:(function() { " + "document.getElementByClass('1-header')[0].style.display=(none); " + "})()");
            }
        });
        myWebView.loadUrl("https://penn.phmschools.org/news");

    }
}
