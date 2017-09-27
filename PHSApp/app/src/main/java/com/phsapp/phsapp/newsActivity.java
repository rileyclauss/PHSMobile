package com.phsapp.phsapp;

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
import com.squareup.picasso.Picasso;

import java.util.List;


public class newsActivity extends AppCompatActivity implements View.OnClickListener, OnRssLoadListener {

    private String[] links = new String[10];
    private String[] imgLinks = new String[10];
    public newsEntry[] newsEntries = new newsEntry[10];
    private TextView[] textViews = new TextView[10];
    private ImageView[] views = new ImageView[10];
    private TextView loadtext = null;
    public int x, y;
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
        String[] urlArr = {"https://penn.phmschools.org/rss.xml"};
        new RssReader(newsActivity.this).showDialog(false).urls(urlArr).parse(this);
    }

    @Override
    public void onSuccess(List<RssItem> rssItems) {

        visibilityFix();


        for (int i = 0; i < 10; i++) {
            x = 0;
            y = 0;
            if (rssItems.get(i).getDescription().contains("article_image")){
                x = rssItems.get(i).getDescription().indexOf(" width=");
                x -= 1;
                y = rssItems.get(i).getDescription().indexOf("article_image");
                y -= 67;
                imgLinks[i] = rssItems.get(i).getDescription().substring(y,x);
            }
            else { imgLinks[i] = "err"; }
            newsEntries[i] = new newsEntry(rssItems.get(i).getTitle(),imgLinks[i],rssItems.get(i).getCategory(),rssItems.get(i).getLink());
        }
        for (int i = 0; i < 10; i++) {
            if (newsEntries[i].getLink() != null) links[i] = newsEntries[i].getLink();
            else { Toast.makeText(this, "Some entries may not have a working link.", Toast.LENGTH_SHORT).show(); }
            if (newsEntries[i].getTitle() != null) textViews[i].setText(newsEntries[i].getTitle());
            else { textViews[i].setText(R.string.noTitle);}
            if(!imgLinks[i].equals("err")) Picasso.with(this).load(imgLinks[i]).into(views[i]);//new ImageDownloaderTask(views[i]).execute(imgLinks[i]);
            else { views[i].setImageResource(R.drawable.noimage); }
        }

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
        int i = Integer.parseInt(v.getTag().toString());
        String url = links[i];
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }
}
