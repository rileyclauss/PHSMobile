package com.phsapp.phsapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.net.URL;
import com.crazyhitty.chdev.ks.rssmanager.*;
import java.util.List;
import android.graphics.drawable.Drawable;
import java.io.InputStream;
import android.view.View.OnClickListener;

public class clubActivity extends AppCompatActivity implements OnRssLoadListener, OnClickListener {
    TextView texts[] = new TextView[9];
    String links[] = new String[9];
    final pl.droidsonroids.gif.GifTextView loading = (pl.droidsonroids.gif.GifTextView) findViewById(R.id.load);
    final TextView ltext = (TextView) findViewById(R.id.textView);
    private void loadFeeds() {
        String[] urlArr = {"https://penn.phmschools.org/rss.xml"};
        new RssReader(clubActivity.this)
                .showDialog(true)
                .urls(urlArr)
                .parse(this);
    }
    @Nullable
    private static Drawable LoadImageFromWebOperations() {
        try {
            InputStream is = (InputStream) new URL("https://penn.phmschools.org/sites/penn.phmschools.org/files/Bio.gif").getContent();
            return Drawable.createFromStream(is, "src name");
        } catch (Exception e) {
            return null;
        }
    }
    public void onSuccess(List<RssItem> rssItems) {
        loading.setVisibility(View.INVISIBLE);
        ltext.setVisibility(View.INVISIBLE);
        texts[0] = (TextView) findViewById(R.id.textView2);
        texts[1] = (TextView) findViewById(R.id.textView3);
        texts[2] = (TextView) findViewById(R.id.textView4);
        texts[3] = (TextView) findViewById(R.id.textView5);
        texts[4] = (TextView) findViewById(R.id.textView6);
        texts[5] = (TextView) findViewById(R.id.textView7);
        texts[6] = (TextView) findViewById(R.id.textView8);
        texts[7] = (TextView) findViewById(R.id.textView9);
        texts[8] = (TextView) findViewById(R.id.textView10);
        texts[9] = (TextView) findViewById(R.id.textView11);
        for(int i=0; i<10; i++){links[i] = rssItems.get(i).getLink();}
        for(int i=0;i<10;i++){texts[i].setText(rssItems.get(i).getTitle());}
        texts[9].setText(rssItems.get(9).getImageUrl());  // MAY OR MAY NOT WORK, the image link seems to be stored in the description rather than in an <imageurl> section
        Drawable d = LoadImageFromWebOperations();
        ImageView loadedimage = (ImageView)findViewById(R.id.imageView);
        loadedimage.setImageDrawable(d);
    }
    public void onFailure(String message) {
        loading.setVisibility(View.INVISIBLE);
        ltext.setVisibility(View.INVISIBLE);
        Toast.makeText(clubActivity.this, "Error: "+message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        for(int i=0; i<10; i++){texts[i].setOnClickListener(clubActivity.this);}
        loading.setVisibility(View.VISIBLE);
        ltext.setVisibility(View.VISIBLE);
        loadFeeds();
    }
    @Override
    public void onClick(View view) {

    }
}
/*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        final pl.droidsonroids.gif.GifTextView loading = (pl.droidsonroids.gif.GifTextView) findViewById(R.id.load);
        final WebView myWebView = (WebView) findViewById(R.id.webview1);
        final TextView ltext = (TextView) findViewById(R.id.textView);
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


