package com.phsapp.phsapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.*;
import android.webkit.*;
import java.util.Arrays;

import com.crazyhitty.chdev.ks.rssmanager.*;

import java.util.List;


public class clubActivity extends AppCompatActivity implements OnRssLoadListener {

    // Begin Work on RSS feeds here.

    //load feeds
    public void loadFeeds() {
        //you can also pass multiple urls
        String[] urlArr = {"https://penn.phmschools.org/rss.xml"};
        new RssReader(clubActivity.this)
                .showDialog(true)
                .urls(urlArr)
                .parse(this);
    }

    public void onSuccess(List<RssItem> rssItems) {
        int yLoc = 20;
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(rssItems.get(0).getTitle());
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText(rssItems.get(1).getTitle());
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setText(rssItems.get(2).getTitle());
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setText(rssItems.get(3).getTitle());
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        textView6.setText(rssItems.get(4).getTitle());
        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setText(rssItems.get(5).getTitle());
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setText(rssItems.get(6).getTitle());
    }

    public void onFailure(String message) {
        Toast.makeText(clubActivity.this, "Error: "+message, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        loadFeeds();

    }
}
/*
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
        myWebView.loadUrl("https://penn.phmschools.org/students-and-parents/get-involved/students");
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                loading.setVisibility(View.INVISIBLE);
                ltext.setVisibility(View.INVISIBLE);
                myWebView.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByTagName('header')[0];"
                        + "head.parentNode.removeChild(head);"+
                        "})()");
                myWebView.setVisibility(View.VISIBLE);
            }
        });
    }


*/


