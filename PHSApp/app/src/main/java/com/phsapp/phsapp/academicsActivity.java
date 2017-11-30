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


    boolean linkstatus = false;   //flag for whether the buttons are for links or Test Schedule, PoS, etc.
    public TextView textViews[] = new TextView[4];  //Text Views under buttons, used for context
    public Button buttons[] = new Button[4];        //Buttons to access respective pages


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academics);  //Sets view to activity_academics
        Toast.makeText(this, "Click any button for more information.", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void customTab(String url) {  //from onClick function, opens Custom Tab page
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();  //basic CustomTabs construction
        CustomTabsIntent customTabsIntent = builder.build();                //
        customTabsIntent.launchUrl(this, Uri.parse(url));                   //url is link to desired page
    }

    boolean links(boolean x) {  //Function to switch between information and Links routine

        textViews[0] = (TextView) findViewById(R.id.testingDaysTextView); // All these assign to
        buttons[0] = (Button) findViewById(R.id.testingDaysButton);       // their respective
                                                                          // objects
        textViews[1] = (TextView) findViewById(R.id.programTextView);     //
        buttons[1] = (Button) findViewById(R.id.programButton);           //
                                                                          //
        textViews[2] = (TextView) findViewById(R.id.altedTextView);       //
        buttons[2] = (Button) findViewById(R.id.altedButton);             //
                                                                          //
        textViews[3] = (TextView) findViewById(R.id.linksTextView);       //
        buttons[3] = (Button) findViewById(R.id.linksButton);             // end


        if (!x) {  //x is a holder for whether the user is on the links page or the info page. True is info to links, false is vice versa
            textViews[0].setText(R.string.HACInfotext);   //sets various text boxes and buttons to
            buttons[0].setText(R.string.HACText);                                       //their respective info

            textViews[1].setText(R.string.CanvasInfotext);
            buttons[1].setText(R.string.CanvasText);

            textViews[2].setText(R.string.PennSiteInfotext);
            buttons[2].setText(R.string.PennSiteText);

            textViews[3].setText(R.string.backInfoText);
            buttons[3].setText(R.string.backText);
            return true;
        }
        else {
            textViews[0].setText(R.string.schoolCalendarInfo);
            buttons[0].setText(R.string.school_schedule);

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
        char target = (v.getTag().toString().charAt(0));  //Each button has a tag assigned to it,
        // this gets it to determine which button is being pressed.
        if (!linkstatus) {       //If the screen is not on the links page
            switch (target) {    //SwitchCase for which button is pressed
                case 'a':
                    customTab("https://penn.phmschools.org/calendars#Penn High School Public Calendar"); //Opens to the general penn calendar page
                    break;
                case 'b':
                    customTab("https://penn.phmschools.org/program-studies"); //Opens page to PoS page
                    break;
                case 'c':
                    customTab("https://penn.phmschools.org/alternative-education-0");  //Opens page to AltEd page
                    break;
                case 'd':
                    linkstatus = links(false);  //Pressing the button labelled "Links" goes to the 'links' function, switching the buttons & text
                    break;
            }
        }
        else{
            switch (target) { //SwitchCase for which button is pressed
                case 'a':
                    customTab("http://hac.phmschools.org/HomeAccess/Account/LogOn?ReturnUrl=%2fHomeAccess%2fClasses%2fClasswork"); //Opens HAC Page
                    break;
                case 'b':
                    customTab("https://phm.instructure.com/login/ldap"); //opens Canvas page
                    break;
                case 'c':
                    customTab("https://penn.phmschools.org"); //Opens Penn website
                    break;
                case 'd':
                    linkstatus = links(true); //Pressing the Back button revers the changes made by the "Links" page
                    break;
            }
        }

    }
}
