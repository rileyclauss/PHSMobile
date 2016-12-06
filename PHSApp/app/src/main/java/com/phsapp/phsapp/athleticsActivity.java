package com.phsapp.phsapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;


public class athleticsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athletics);
    }/*
    private void loadFeeds() {
        //you can also pass multiple urls
        String[] urlArr = {"http://feeds.bbci.co.uk/news/rss.xml"};
        new RssReader(athleticsActivity.this)
                .showDialog(true)
                .urls(urlArr)
                .parse(this);
    }

    @Override
    public void onSuccess(List<RssItem> rssItems) {
        Toast.makeText(athleticsActivity.this, "Item: "+rssItems.get(0).getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(athleticsActivity.this, "Error: "+message, Toast.LENGTH_SHORT).show();
    }
    */
}
