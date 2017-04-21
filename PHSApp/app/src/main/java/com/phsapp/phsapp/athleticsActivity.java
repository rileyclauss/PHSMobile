package com.phsapp.phsapp;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.crazyhitty.chdev.ks.rssmanager.OnRssLoadListener;
import com.crazyhitty.chdev.ks.rssmanager.RssItem;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.List;

public class athleticsActivity extends AppCompatActivity implements OnRssLoadListener{
    String links[] = new String[10];
    TextView texts[] = new TextView[10];
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
        Toast.makeText(athleticsActivity.this, rssItems.get(1).getTitle(), Toast.LENGTH_SHORT).show();
        //texts[0] = (TextView) findViewById(R.id.textView54);
        //for(int i=0; i<10; i++){links[i] = rssItems.get(i).getLink();}
        //for(int i=0;i<10;i++){texts[i].setText(rssItems.get(i).getTitle());}
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(athleticsActivity.this, "Error: "+message, Toast.LENGTH_SHORT).show();
    }
}
