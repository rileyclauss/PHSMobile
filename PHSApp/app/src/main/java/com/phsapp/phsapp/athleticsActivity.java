package com.phsapp.phsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import com.crazyhitty.chdev.ks.rssmanager.OnRssLoadListener;
import com.crazyhitty.chdev.ks.rssmanager.RssItem;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.List;

import pl.droidsonroids.gif.GifTextView;

import static com.phsapp.phsapp.R.id.match_parent;


public class athleticsActivity extends AppCompatActivity implements View.OnClickListener, OnRssLoadListener {



    private TextView[] labels = new TextView[2];
    private String[][] links = new String[2][5];
    private Space[][] spacers = new Space[2][5];
    public boolean[] entry = new boolean[2];
    public newsEntry[] athleticsEntries = new newsEntry[10];
    private TextView[][] textViews = new TextView[2][5];
    private ImageView[][] views = new ImageView[2][5];
    private Boolean[][] entries = new Boolean[2][5]; //Checks to see if that spot is already filled when sorting news articles
    private TextView loadtext = null;
    private pl.droidsonroids.gif.GifTextView loadgif = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athletics);
        loadtext = (TextView) findViewById(R.id.textView);
        loadgif = (pl.droidsonroids.gif.GifTextView) findViewById(R.id.load);
        declareStatic();
        loadFeeds();
    }

    private void declareStatic(){
        for (int i = 0;i<5;i++){
            entries[0][i] = false;
            entries[1][i] = false;
        }
        entry[0] = false;
        entry[1] = false;

        loadtext = (TextView) findViewById(R.id.textView);
        loadgif = (GifTextView) findViewById(R.id.load);

        labels[0] = (TextView) findViewById(R.id.boysHeader);
        labels[1] = (TextView) findViewById(R.id.girlsHeader);

        textViews[0][0] = (TextView) findViewById(R.id.sportsText0);
        textViews[0][1] = (TextView) findViewById(R.id.sportsText1);
        textViews[0][2] = (TextView) findViewById(R.id.sportsText2);
        textViews[0][3] = (TextView) findViewById(R.id.sportsText3);
        textViews[0][4] = (TextView) findViewById(R.id.sportsText4);
        textViews[1][0] = (TextView) findViewById(R.id.sportsText5);
        textViews[1][1] = (TextView) findViewById(R.id.sportsText6);
        textViews[1][2] = (TextView) findViewById(R.id.sportsText7);
        textViews[1][3] = (TextView) findViewById(R.id.sportsText8);
        textViews[1][4] = (TextView) findViewById(R.id.sportsText9);

        spacers[0][0] = (Space) findViewById(R.id.space0);
        spacers[0][1] = (Space) findViewById(R.id.space1);
        spacers[0][2] = (Space) findViewById(R.id.space2);
        spacers[0][3] = (Space) findViewById(R.id.space3);
        spacers[0][4] = (Space) findViewById(R.id.space4);
        spacers[1][0] = (Space) findViewById(R.id.space5);
        spacers[1][1] = (Space) findViewById(R.id.space6);
        spacers[1][2] = (Space) findViewById(R.id.space7);
        spacers[1][3] = (Space) findViewById(R.id.space8);
        spacers[1][4] = (Space) findViewById(R.id.space9);

        views[0][0] = (ImageView) findViewById(R.id.sportsImage0);
        views[0][1] = (ImageView) findViewById(R.id.sportsImage1);
        views[0][2] = (ImageView) findViewById(R.id.sportsImage2);
        views[0][3] = (ImageView) findViewById(R.id.sportsImage3);
        views[0][4] = (ImageView) findViewById(R.id.sportsImage4);
        views[1][0] = (ImageView) findViewById(R.id.sportsImage5);
        views[1][1] = (ImageView) findViewById(R.id.sportsImage6);
        views[1][2] = (ImageView) findViewById(R.id.sportsImage7);
        views[1][3] = (ImageView) findViewById(R.id.sportsImage8);
        views[1][4] = (ImageView) findViewById(R.id.sportsImage9);

    }

    private void loadFeeds() {
        String[] urlArr = {"http://pennant.phmschools.org/feed/"};
        new RssReader(athleticsActivity.this).showDialog(false).urls(urlArr).parse(this);
    }

    @Override
    public void onSuccess(List<RssItem> rssItems) {

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(match_parent, 20);
        int x, y;
        for (int i = 0;i<10;i++) {
            if (rssItems.get(i).getDescription().contains("uploads")) {
                x = rssItems.get(i).getDescription().indexOf(" src");
                x += 6;
                y = rssItems.get(i).getDescription().indexOf(" alt");
                y -= 1;

                athleticsEntries[i] = new newsEntry(rssItems.get(i).getTitle(), rssItems.get(i).getDescription().substring(x, y), rssItems.get(i).getCategory(), rssItems.get(i).getLink());
            }
        }

        for (int i = 0; i < 10; i++) {
            if (athleticsEntries[i].getCategory().equals("Girls Sports")) {
                entry[1] = true;
                int z = 0;
                while (entries[1][z] && z<5) {
                    z++;
                }
                if (!entries[1][z]) {
                    if(athleticsEntries[i].getImgLink() != null) new ImageDownloaderTask(views[1][z]).execute(athleticsEntries[i].getImgLink());
                    else{views[1][z].setImageResource(R.drawable.noimage);}
                    entries[1][z] = true;
                    if (athleticsEntries[i].getLink() != null) links[1][z] = athleticsEntries[i].getLink();
                    if (athleticsEntries[i].getTitle() != null) textViews[1][z].setText(athleticsEntries[i].getTitle());
                    else { textViews[1][z].setText(R.string.noTitle);}
                    spacers[1][z].setLayoutParams(params);
                }
            } else if (!athleticsEntries[i].getCategory().equals("Boys Sports") && !athleticsEntries[i].getCategory().equals("Photo Gallery")) {
                entry[0] = true;
                int z = 0;
                while (entries[0][z] && z<5) {
                    z++;
                }
                if (!entries[0][z]) {
                    if(athleticsEntries[i].getImgLink() != null) new ImageDownloaderTask(views[0][z]).execute(athleticsEntries[i].getImgLink());
                    else{ views[0][z].setImageResource(R.drawable.noimage);}
                    entries[0][z] = true;
                    if (athleticsEntries[i].getLink() != null) links[0][z] = athleticsEntries[i].getLink();
                    if (athleticsEntries[i].getTitle() != null) textViews[0][z].setText(athleticsEntries[i].getTitle());
                    else { textViews[0][z].setText(R.string.noTitle); }
                    spacers[0][z].setLayoutParams(params);
                }
            }
            if (i == 9 && !entry[0]){
                textViews[0][1].setText(R.string.noentries);
            }
            if (i == 9 && !entry[1]){
                textViews[1][1].setText(R.string.noentries);
            }
        }
        visibilityFix();
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
        labels[0].setVisibility(View.VISIBLE);
        labels[1].setVisibility(View.VISIBLE);
        for (int i=0;i<5;i++){
            textViews[0][i].setVisibility(View.VISIBLE);
            views[0][i].setVisibility(View.VISIBLE);
            textViews[1][i].setVisibility(View.VISIBLE);
            views[1][i].setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        String url;
        int x = Integer.parseInt(v.getTag().toString());
        if (x == 99){
            url = "http://pennant.phmschools.org/";
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(this, Uri.parse(url));
        }
        if (x!=99){
            if (x < 5) {
               url = links[0][x];
            }
            else{
                x -=5;
                url = links[1][x];
            }
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(this, Uri.parse(url));
        }
    }

}

