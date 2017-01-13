package com.phsapp.phsapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.*;
import android.webkit.*;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import com.crazyhitty.chdev.ks.rssmanager.OnRssLoadListener;
import com.crazyhitty.chdev.ks.rssmanager.RssItem;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;
import java.util.List;
import android.view.View.OnClickListener;
import static android.R.id.message;
import static com.phsapp.phsapp.R.layout.activity_news;


public class newsActivity extends AppCompatActivity implements OnRssLoadListener, OnClickListener  {
  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
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
                myWebView.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByID('main-header')[0];"
                        + "head.parentNode.removeChild(head);"+
                        "})()");
                myWebView.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByTagName('main-footer')[0];"
                        + "head.parentNode.removeChild(head);"+
                        "})()");
                loading.setVisibility(View.INVISIBLE);
                ltext.setVisibility(View.INVISIBLE);
                myWebView.setVisibility(View.VISIBLE);
            }
        }
        );
    }*/
    public void loadFeeds() {
        //you can also pass multiple urls
        String[] urlArr = {"https://penn.phmschools.org/rss.xml"};
        new RssReader(newsActivity.this)
                .showDialog(false)
                .urls(urlArr)
                .parse(this);
    }
    public void onSuccess(List<RssItem> rssItems) {
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
        TextView textView9 = (TextView) findViewById(R.id.textView9);
        textView9.setText(rssItems.get(7).getTitle());
        TextView textView10 = (TextView) findViewById(R.id.textView10);
        textView10.setText(rssItems.get(8).getTitle());
        TextView textView11 = (TextView) findViewById(R.id.textView11);
        textView11.setText(rssItems.get(9).getLink());
    }
    @Override
    public void onClick(View view) {
            String url = "https://paul.kinlan.me/";
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl((Activity) getApplicationContext(), Uri.parse(url));
            Toast.makeText(newsActivity.this, "Error: ", Toast.LENGTH_SHORT).show();
    }
    public void onFailure(String message) {
        Toast.makeText(newsActivity.this, "Error: "+message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        loadFeeds();
    }
}