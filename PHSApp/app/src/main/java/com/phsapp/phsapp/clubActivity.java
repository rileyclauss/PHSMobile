package com.phsapp.phsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.*;
import android.webkit.*;
import com.crazyhitty.chdev.ks.rssmanager.*;

import java.util.List;

public class clubActivity extends AppCompatActivity implements OnRssLoadListener {
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

    // Begin Work on RSS feeds here.

    //load feeds
    private void loadFeeds() {
        //you can also pass multiple urls
        String[] urlArr = {"http://feeds.bbci.co.uk/news/rss.xml"};
        new RssReader(clubActivity.this)
                .showDialog(true)
                .urls(urlArr)
                .parse(this);
    }

    public void onSuccess(List<RssItem> rssItems) {
        Toast.makeText(clubActivity.this, "Item: "+rssItems.get(0).getTitle(), Toast.LENGTH_SHORT).show();
    }

    public void onFailure(String message) {
        Toast.makeText(clubActivity.this, "Error: "+message, Toast.LENGTH_SHORT).show();
    }
}
