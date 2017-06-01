package com.phsapp.phsapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class academicsActivity extends AppCompatActivity implements View.OnClickListener {
    boolean linkstatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academics);
        Toast.makeText(this, "Click any button for more information.", Toast.LENGTH_LONG).show();
    }

    public void customTab(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }

    boolean links(boolean x) {

        TextView textViews[] = new TextView[4];
        Button buttons[] = new Button[4];


        textViews[0] = (TextView) findViewById(R.id.testingDaysTextView);
        buttons[0] = (Button) findViewById(R.id.testingDaysButton);

        textViews[1] = (TextView) findViewById(R.id.programTextView);
        buttons[1] = (Button) findViewById(R.id.programButton);

        textViews[2] = (TextView) findViewById(R.id.altedTextView);
        buttons[2] = (Button) findViewById(R.id.altedButton);

        textViews[3] = (TextView) findViewById(R.id.linksTextView);
        buttons[3] = (Button) findViewById(R.id.linksButton);


        if (!x) {
            textViews[0].setText(R.string.HACInfotext);
            buttons[0].setText(R.string.HACText);

            textViews[1].setText(R.string.CanvasInfotext);
            buttons[1].setText(R.string.CanvasText);

            textViews[2].setText(R.string.PennSiteInfotext);
            buttons[2].setText(R.string.PennSiteText);

            textViews[3].setText(R.string.backInfoText);
            buttons[3].setText(R.string.backText);
            return true;
        }
        else {
            textViews[0].setText(R.string.testDatesInfo);
            buttons[0].setText(R.string.testing_schedule);

            textViews[1].setText(R.string.programofstudiesInfo);
            buttons[1].setText(R.string.program_of_studies);

            textViews[2].setText(R.string.altedInfo);
            buttons[2].setText(R.string.alted_information);

            textViews[3].setText(R.string.linksInfo);
            buttons[3].setText(R.string.links);
            return false;
        }
    }

    public void onClick(View v) {
        char target = (v.getTag().toString().charAt(0));

        if (!linkstatus) {
            switch (target) {
                case 'a':
                    customTab("https://penn.phmschools.org/testing-dates");
                    break;
                case 'b':
                    customTab("https://penn.phmschools.org/program-studies");
                    break;
                case 'c':
                    customTab("https://penn.phmschools.org/alternative-education-0");
                    break;
                case 'd':
                    linkstatus = links(false);
                    break;
            }
        }
        else{
            switch (target) {
                case 'a':
                    customTab("http://hac.phmschools.org/HomeAccess/Account/LogOn?ReturnUrl=%2fHomeAccess%2fClasses%2fClasswork");
                    break;
                case 'b':
                    customTab("https://phm.instructure.com/login/ldap");
                    break;
                case 'c':
                    customTab("https://penn.phmschools.org");
                    break;
                case 'd':
                    linkstatus = links(true);
                    break;
            }
        }

    }
}
