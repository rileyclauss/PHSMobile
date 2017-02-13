package com.phsapp.phsapp;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;
import com.crazyhitty.chdev.ks.rssmanager.*;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class newsActivity extends AppCompatActivity implements OnRssLoadListener, View.OnClickListener{
    String links[] = new String[10];
    TextView texts[] = new TextView[10];
    Drawable images[] = new Drawable[10];
    ImageView views[] = new ImageView[10];
    private TextView loadtext = null;
    private pl.droidsonroids.gif.GifTextView loadgif = null;
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_news);
       loadtext = (TextView) findViewById(R.id.textView);
       loadgif = (pl.droidsonroids.gif.GifTextView) findViewById(R.id.load);
       loadFeeds();
   }
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
        //views[0] = (ImageView) findViewById(R.id.imageView3);
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
        int x, y;
     /*   for(int i=0;i<10;i++){
            x = rssItems.get(i).getDescription().indexOf(" width=");
            x-= 1;
            y = rssItems.get(i).getDescription().indexOf("article_image");
            y -=67;
            images[i] = LoadImageFromWebOperations(rssItems.get(i).getDescription().substring(y, x));
        } */
        for(int i=0; i<10; i++){links[i] = rssItems.get(i).getLink();}
        for(int i=0;i<10;i++){texts[i].setText(rssItems.get(i).getTitle());}
    }
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
    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}