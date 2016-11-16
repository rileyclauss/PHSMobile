package com.phsapp.phsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://penn.phmschools.org/news");
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });

    }

 /**   public void onPageFinished(WebView view, String url) {

        webview.loadUrl("javascript:(function() { " +
                "var head = document.getElementsByClassName('header'); head.[0].style.display='none'; })()");
        webview.loadUrl("javascript:(function() { " +
                "var bott = document.getElementsByClassName('sidebar-homepage')[0];"
                + "bott.parentNode.removeChild(bott);"+
                "})()");

    }**/
}
