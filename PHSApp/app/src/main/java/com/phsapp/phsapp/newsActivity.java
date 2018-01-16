package com.phsapp.phsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.crazyhitty.chdev.ks.rssmanager.RSS;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;
import com.squareup.picasso.Picasso;


import java.io.InputStream;
import java.util.List;


public class newsActivity extends AppCompatActivity implements View.OnClickListener{

//}, RssReader.RssCallback{


    public newsEntry[] newsEntries = new newsEntry[10];
   // private RssReader rssReader = new RssReader(this);


    private String[] links = new String[10];
    private String[] imgLinks = new String[10];
    private TextView[] textViews = new TextView[10];
    private ImageView[] views = new ImageView[10];
    public int x, y;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);




        declareStatic();
        String[] urlArr = {"https://www.drupal.org/planeta/rss.xml"};
       // rssReader.loadFeeds(urlArr);
    }




    @Override
    public void onClick(View v) {

    }

    private void declareStatic(){

        /*textViews[0] = (TextView) findViewById(R.id.newsText0);
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
*/
    }



/*
    @Override
    public void rssFeedsLoaded(List<RSS> rssItems) {
        visibilityFix();
        for (int i = 0; i < 10; i++) {
            x = 0;
            y = 0;
            if (rssItems.get(0).getChannel().getItems().get(i).getDescription().contains("article_image")){
                x = rssItems.get(0).getChannel().getItems().get(i).getDescription().indexOf(" width=");
                x -= 1;
                y = rssItems.get(0).getChannel().getItems().get(i).getDescription().indexOf("article_image");
                y -= 67;
                imgLinks[i] = rssItems.get(0).getChannel().getItems().get(i).getDescription().substring(y,x);
            }
            else { imgLinks[i] = "err"; }
            newsEntries[i] = new newsEntry(rssItems.get(0).getChannel().getItems().get(i).getTitle(),
                    imgLinks[i],rssItems.get(0).getChannel().getItems().get(i).getCategory(),
                    rssItems.get(0).getChannel().getItems().get(i).getLink());
        }
        for (int i = 0; i < 10; i++) {
            if (newsEntries[i].getLink() != null) links[i] = newsEntries[i].getLink();
            else { Toast.makeText(this, "Some entries may not have a working link.", Toast.LENGTH_SHORT).show(); }
            if (newsEntries[i].getTitle() != null) textViews[i].setText(newsEntries[i].getTitle());
            else { textViews[i].setText(R.string.noTitle);}
            if(!imgLinks[i].equals("err")) Picasso.with(this).load(imgLinks[i]).into(views[i]);
            else { views[i].setImageResource(R.drawable.noimage); }
        }

    }

    @Override
    public void unableToReadRssFeeds(String message) {
        Toast.makeText(this, message , Toast.LENGTH_LONG).show();
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
        customTab.openTab(this,links[i]);
    } */
}
