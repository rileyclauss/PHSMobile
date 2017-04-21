package com.phsapp.phsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
//import com.crazyhitty.chdev.ks.rssmanager.OnRssLoadListener;
import com.crazyhitty.chdev.ks.rssmanager.RssItem;
//import com.crazyhitty.chdev.ks.rssmanager.RssReader;
import java.util.List;
//import pl.droidsonroids.gif.GifTextView;

public class newsActivity extends AppCompatActivity implements View.OnClickListener{
   /* private final String[] links = new String[5];
    private final String[] imgLinks = new String[5];
    private final TextView[] textViews = new TextView[5];
    private final ImageView[] views = new ImageView[5];
    private TextView loadtext = null;
    private pl.droidsonroids.gif.GifTextView loadgif = null;*/
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_news);
     //  loadtext = (TextView) findViewById(R.id.textView);
     //  loadgif = (pl.droidsonroids.gif.GifTextView) findViewById(R.id.load);
       //declareStatic();
      // loadFeeds();
   }/*
    private void loadFeeds() {
        String[] urlArr = {"https://penn.phmschools.org/rss.xml"};
        new RssReader(newsActivity.this)
                .showDialog(false)
                .urls(urlArr)
                .parse(this);
    }
*/
    public void onSuccess(List<RssItem> rssItems) {
       /* visibilityFix();
        int x, y;
        for (int i = 0; i < 5; i++) {
            x = rssItems.get(i).getDescription().indexOf(" width=");
            x -= 1;
            y = rssItems.get(i).getDescription().indexOf("article_image");
            y -= 67;
            imgLinks[i] = rssItems.get(i).getDescription().substring(y, x);
        }
        for(int i = 0; i < 5; i++) { links[i] = rssItems.get(i).getLink(); }
        for (int i = 0; i < 5; i++) { links[i] = rssItems.get(i).getLink(); }
        for (int i = 0; i < 5; i++) { textViews[i].setText(rssItems.get(i).getTitle()); }
    }
    private void visibilityFix(){
        loadgif.setVisibility(View.INVISIBLE);
        loadtext.setVisibility(View.INVISIBLE);
        for (int i=0;i<6;i++){
            textViews[i].setVisibility(View.VISIBLE);
            views[i].setVisibility(View.VISIBLE);
        }*/
    }/*
    private void declareStatic(){
        loadtext = (TextView) findViewById(R.id.textView);
        loadgif = (GifTextView) findViewById(R.id.load);
        textViews[0] = (TextView) findViewById(R.id.textView1);
        textViews[1] = (TextView) findViewById(R.id.textView2);
        textViews[2] = (TextView) findViewById(R.id.textView3);
        textViews[3] = (TextView) findViewById(R.id.textView4);
        textViews[4] = (TextView) findViewById(R.id.textView5);
        textViews[5] = (TextView) findViewById(R.id.textView6);
        views[0] = (ImageView) findViewById(R.id.imageView3);
        views[1] = (ImageView) findViewById(R.id.imageView4);
        views[2] = (ImageView) findViewById(R.id.imageView5);
        views[3] = (ImageView) findViewById(R.id.imageView6);
        views[4] = (ImageView) findViewById(R.id.imageView7);
        views[5] = (ImageView) findViewById(R.id.imageView8);
    }*/
    @Override
    public void onClick(View view) {
      /*      String url = "https://paul.kinlan.me/";
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl((Activity) getApplicationContext(), Uri.parse(url));
            Toast.makeText(newsActivity.this, "This is a test message", Toast.LENGTH_SHORT).show();*/
    }
    public void onFailure(String message) {
        Toast.makeText(newsActivity.this, "Error: "+message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}