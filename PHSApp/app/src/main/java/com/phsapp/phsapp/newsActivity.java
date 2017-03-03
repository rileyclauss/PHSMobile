package com.phsapp.phsapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.crazyhitty.chdev.ks.rssmanager.OnRssLoadListener;
import com.crazyhitty.chdev.ks.rssmanager.RssItem;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;
import java.util.List;
import pl.droidsonroids.gif.GifTextView;

public class newsActivity extends AppCompatActivity implements OnRssLoadListener, View.OnClickListener {
    String newsLinks[] = new String[6];
    String imgLinks[] = new String[6];
    TextView textViews[] = new TextView[6];
    Drawable images[] = new Drawable[6];
    ImageLoader imageLoader;
    private NetworkImageView views[];
    private TextView loadtext = null;
    private pl.droidsonroids.gif.GifTextView loadgif = null;
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_news);
       declareStatic();
       loadFeeds();
   }
    private void loadFeeds() {
        String[] urlArr = {"https://penn.phmschools.org/rss.xml"};
        new RssReader(newsActivity.this)
                .showDialog(false)
                .urls(urlArr)
                .parse(this);
    }
    @Override
    public void onSuccess(List<RssItem> rssItems) {
        visibilityFix();
        int x, y;
        for (int i = 0; i < 6; i++) {
            x = rssItems.get(i).getDescription().indexOf(" width=");
            x -= 1;
            y = rssItems.get(i).getDescription().indexOf("article_image");
            y -= 67;
            imgLinks[i] = rssItems.get(i).getDescription().substring(y, x);
        }
        CustomVolleyRequest CustomVolleyRequest = new CustomVolleyRequest(newsActivity.this);
        imageLoader = CustomVolleyRequest.getInstance(this.getApplicationContext())
                .getImageLoader();
        imageLoader.get(imgLinks[1], ImageLoader.getImageListener(views[1],
                R.drawable.blacksquare, android.R.drawable.ic_dialog_alert));
        views[1].setImageUrl(imgLinks[1], imageLoader);
        for (int i = 0; i < 6; i++) { newsLinks[i] = rssItems.get(i).getLink(); }
        for (int i = 0; i < 6; i++) { textViews[i].setText(rssItems.get(i).getTitle()); }
    }


    public void visibilityFix(){
        loadgif.setVisibility(View.INVISIBLE);
        loadtext.setVisibility(View.INVISIBLE);
        for (int i=0;i<6;i++){
            textViews[i].setVisibility(View.VISIBLE);
            views[i].setVisibility(View.VISIBLE);
        }
    }
    public void declareStatic(){
        loadtext = (TextView) findViewById(R.id.textView);
        loadgif = (GifTextView) findViewById(R.id.load);
        textViews[0] = (TextView) findViewById(R.id.textView1);
        textViews[1] = (TextView) findViewById(R.id.textView2);
        textViews[2] = (TextView) findViewById(R.id.textView3);
        textViews[3] = (TextView) findViewById(R.id.textView4);
        textViews[4] = (TextView) findViewById(R.id.textView5);
        textViews[5] = (TextView) findViewById(R.id.textView6);
        views[0] = (NetworkImageView) findViewById(R.id.imageView3);
        views[1] = (NetworkImageView) findViewById(R.id.imageView4);
        views[2] = (NetworkImageView) findViewById(R.id.imageView5);
        views[3] = (NetworkImageView) findViewById(R.id.imageView6);
        views[4] = (NetworkImageView) findViewById(R.id.imageView7);
        views[5] = (NetworkImageView) findViewById(R.id.imageView8);
    }
    @Override
    public void onClick(View view) {
        /*  String url = "https://paul.kinlan.me/";
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl((Activity) getApplicationContext(), Uri.parse(url));
            Toast.makeText(newsActivity.this, "This is a test message", Toast.LENGTH_SHORT).show();*/
    }
    public void onFailure(String message) {
        Toast.makeText(newsActivity.this, "Error: "+message, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}