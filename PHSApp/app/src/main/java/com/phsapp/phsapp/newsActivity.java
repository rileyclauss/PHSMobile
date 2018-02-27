package com.phsapp.phsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class newsActivity extends AppCompatActivity implements View.OnClickListener{

    public newsEntry[] newsEntries = new newsEntry[10];
    private String[] links = new String[10];
    private String[] imgLinks = new String[10];
    private TextView[] textViews = new TextView[10];
    private ImageView[] views = new ImageView[10];
    public int x, y;

    String urlString = "https://penn.phmschools.org/rss.xml";
    Parser parser = new Parser();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        declareStatic();

        parser.execute(urlString);
        parser.onFinish(new Parser.OnTaskCompleted() {

            @Override
            public void onTaskCompleted(ArrayList<Article> list) {
                display(list);
            }

            @Override
            public void onError() {
                err();
            }
        });
    }
    private void err(){
        this.runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(newsActivity.this, "Unable to reach server; please check your connection.", Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void display(ArrayList<Article> rssItems){
        for (int i = 0; i < 10; i++) {
            x = 0;
            y = 0;
            if (rssItems.get(i).getDescription().contains("article_image")) {
                x = rssItems.get(i).getDescription().indexOf(" width=");
                x -= 1;
                y = rssItems.get(i).getDescription().indexOf("article_image");
                y -= 67;
                imgLinks[i] = rssItems.get(i).getDescription().substring(y, x);
            } else {
                imgLinks[i] = "err";
            }
            newsEntries[i] = new newsEntry(rssItems.get(i).getTitle(),
                    imgLinks[i], rssItems.get(i).getCategories(),
                    rssItems.get(i).getLink());
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
    protected void onDestroy() {
        super.onDestroy();


    }
    private void declareStatic(){
        textViews[0] = findViewById(R.id.newsText0);
        textViews[1] = findViewById(R.id.newsText1);
        textViews[2] = findViewById(R.id.newsText2);
        textViews[3] = findViewById(R.id.newsText3);
        textViews[4] = findViewById(R.id.newsText4);
        textViews[5] = findViewById(R.id.newsText5);
        textViews[6] = findViewById(R.id.newsText6);
        textViews[7] = findViewById(R.id.newsText7);
        textViews[8] = findViewById(R.id.newsText8);
        textViews[9] = findViewById(R.id.newsText9);

        views[0] = findViewById(R.id.newsImage0);
        views[1] = findViewById(R.id.newsImage1);
        views[2] = findViewById(R.id.newsImage2);
        views[3] = findViewById(R.id.newsImage3);
        views[4] = findViewById(R.id.newsImage4);
        views[5] = findViewById(R.id.newsImage5);
        views[6] = findViewById(R.id.newsImage6);
        views[7] = findViewById(R.id.newsImage7);
        views[8] = findViewById(R.id.newsImage8);
        views[9] = findViewById(R.id.newsImage9);
    }

    @Override
    public void onClick(View v) {
        int i = Integer.parseInt(v.getTag().toString());
        customTab.openTab(this,links[i]);
    }
}
