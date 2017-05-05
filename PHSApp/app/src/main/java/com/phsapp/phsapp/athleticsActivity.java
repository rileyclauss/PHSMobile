package com.phsapp.phsapp;
//TODO Divide sections into different sports
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.crazyhitty.chdev.ks.rssmanager.OnRssLoadListener;
import com.crazyhitty.chdev.ks.rssmanager.RssItem;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.List;

import pl.droidsonroids.gif.GifTextView;


public class athleticsActivity extends AppCompatActivity implements View.OnClickListener, OnRssLoadListener {

    private String[] links = new String[10];
    private String[] imgLinks = new String[10];
    private TextView[] textViews = new TextView[10];
    private ImageView[] views = new ImageView[10];
    private TextView loadtext = null;
    private pl.droidsonroids.gif.GifTextView loadgif = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        loadtext = (TextView) findViewById(R.id.textView);
        loadgif = (pl.droidsonroids.gif.GifTextView) findViewById(R.id.load);
        declareStatic();
        loadFeeds();
    }

    private void declareStatic(){
        loadtext = (TextView) findViewById(R.id.textView);
        loadgif = (GifTextView) findViewById(R.id.load);

        textViews[0] = (TextView) findViewById(R.id.newsText0);
        textViews[1] = (TextView) findViewById(R.id.newsText1);
        textViews[2] = (TextView) findViewById(R.id.newsText2);
        textViews[3] = (TextView) findViewById(R.id.newsText3);
        textViews[4] = (TextView) findViewById(R.id.newsText4);
        textViews[5] = (TextView) findViewById(R.id.newsText5);
        textViews[6] = (TextView) findViewById(R.id.newsText6);
        textViews[7] = (TextView) findViewById(R.id.newsText7);
        textViews[8] = (TextView) findViewById(R.id.newsText8);
        textViews[9] = (TextView) findViewById(R.id.newsText9);

        views[0] = (ImageView) findViewById(R.id.newsImage0);
        views[1] = (ImageView) findViewById(R.id.newsImage1);
        views[2] = (ImageView) findViewById(R.id.newsImage2);
        views[3] = (ImageView) findViewById(R.id.newsImage3);
        views[4] = (ImageView) findViewById(R.id.newsImage4);
        views[5] = (ImageView) findViewById(R.id.newsImage5);
        views[6] = (ImageView) findViewById(R.id.newsImage6);
        views[7] = (ImageView) findViewById(R.id.newsImage7);
        views[8] = (ImageView) findViewById(R.id.newsImage8);
        views[9] = (ImageView) findViewById(R.id.newsImage9);

    }

    private void loadFeeds() {
        String[] urlArr = {"http://pennant.phmschools.org/feed/"};
        new RssReader(athleticsActivity.this).showDialog(false).urls(urlArr).parse(this);
    }

    @Override
    public void onSuccess(List<RssItem> rssItems) {

        visibilityFix();


        for (int i = 0; i < 10; i++) { links[i] = rssItems.get(i).getLink(); }
        for (int i = 0; i < 10; i++) { textViews[i].setText(rssItems.get(i).getTitle()); }

        Toast.makeText(this, "Tap on an article for more information" , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, "An error occured, please check your internet connection." , Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void visibilityFix(){
        loadgif.setVisibility(View.INVISIBLE);
        loadtext.setVisibility(View.INVISIBLE);
        for (int i=0;i<10;i++){
            textViews[i].setVisibility(View.VISIBLE);
            views[i].setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getTag().toString().equals("0")){
            String url = links[0];
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(url));
        }
        else if (v.getTag().toString().equals("1")){
            String url = links[1];
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(url));
        }
        else if (v.getTag().toString().equals("2")){
            String url = links[2];
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(url));
        }
        else if (v.getTag().toString().equals("3")){
            String url = links[3];
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(url));
        }
        else if (v.getTag().toString().equals("4")){
            String url = links[4];
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(url));
        }
        else if (v.getTag().toString().equals("5")){
            String url = links[5];
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(url));
        }
        else if (v.getTag().toString().equals("6")){
            String url = links[6];
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(url));
        }
        else if (v.getTag().toString().equals("7")){
            String url = links[7];
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(url));
        }
        else if (v.getTag().toString().equals("8")){
            String url = links[8];
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(url));
        }
        else if (v.getTag().toString().equals("9")){
            String url = links[9];
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(url));
        }

    }
}

