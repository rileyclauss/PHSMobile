package com.phsapp.phsapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class fineartsActivity extends AppCompatActivity{

    public String[] links = new String[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finearts);

        declareLinks();
    }
    public void declareLinks(){
        links[0] = "http://www.pennbands.com/";
        links[1] = "http://www.pennchoir.com/";
        links[2] = "https://penn.phmschools.org/dance-events-calendar";
        links[3] = "https://penn.phmschools.org/theater-events-calendar";
        links[4] = "http://annetschetter.wixsite.com/pennorchestras";
        links[5] = "https://penn.phmschools.org/visual-arts";
        links[6] = "https://www.ticketracker.com/store/events/1529";
    }
    public void onClick(View v) {
        int target = Integer.parseInt(v.getTag().toString());
        String url = links[target];
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }
}



