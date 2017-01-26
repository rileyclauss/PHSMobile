package com.phsapp.phsapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.crazyhitty.chdev.ks.rssmanager.OnRssLoadListener;
import com.crazyhitty.chdev.ks.rssmanager.RssItem;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.support.customtabs.CustomTabsIntent;
import java.util.List;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class athleticsActivity extends AppCompatActivity implements OnRssLoadListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athletics);
        loadFeeds();

    }
    private void loadFeeds() {
        //you can also pass multiple urls
        String[] urlArr = {"http://pennant.phmschools.org/feed/"};
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
}
