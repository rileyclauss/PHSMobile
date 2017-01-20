package com.phsapp.phsapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import pl.droidsonroids.gif.*;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.support.customtabs.CustomTabsIntent;
import com.crazyhitty.chdev.ks.rssmanager.OnRssLoadListener;
import com.crazyhitty.chdev.ks.rssmanager.RssItem;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;
import java.util.List;


public class newsActivity extends AppCompatActivity implements OnRssLoadListener, View.OnClickListener{
     String links[] = new String[10];
     TextView texts[] = new TextView[10];
    private TextView loadtext = null;
    private pl.droidsonroids.gif.GifTextView loadgif = null;
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_news);
       loadtext = (TextView)findViewById(R.id.textView);
       loadgif = (pl.droidsonroids.gif.GifTextView)findViewById(R.id.load);
       loadFeeds();
   }
  /*  @Override                                                                                      KEEP THIS CODE, DELETE WHEN WE'VE FINALIZED IT
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
  private void loadFeeds() {
        String[] urlArr = {"https://penn.phmschools.org/rss.xml"};
        new RssReader(newsActivity.this)
                .showDialog(false)
                .urls(urlArr)
                .parse(this);
    }
    public void onSuccess(List<RssItem> rssItems) {
        loadgif.setVisibility(View.INVISIBLE);
        loadtext.setVisibility(View.INVISIBLE);
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
        Toast.makeText(newsActivity.this, "This is a test message", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View view) {
            String url = "https://paul.kinlan.me/";
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl((Activity) getApplicationContext(), Uri.parse(url));
            Toast.makeText(newsActivity.this, "This is a test message", Toast.LENGTH_SHORT).show();
    }
    public void onFailure(String message) {
        Toast.makeText(newsActivity.this, "Error: "+message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}