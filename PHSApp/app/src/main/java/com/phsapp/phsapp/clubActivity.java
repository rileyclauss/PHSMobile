package com.phsapp.phsapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.net.Uri;
import android.widget.Toast;

import static android.support.customtabs.CustomTabsIntent.*;


public class clubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        TextView t0 = new TextView(this);
        t0=(TextView)findViewById(R.id.textView);
        Toast.makeText(clubActivity.this, "Tap on any club for more information.",
                Toast.LENGTH_LONG).show();
    }
    public String parser(View v){
        switch (v.getId()) {
            case R.id.textView:
                return "https://penn.phmschools.org/asl-club";

            case R.id.textView1:
                return "https://penn.phmschools.org/amnesty-international";
            case R.id.textView2:
                return "https://penn.phmschools.org/art-club";
            case R.id.textView3:
                return "https://penn.phmschools.org/first-friday-book-club";
            case R.id.textView4:
                return "https://penn.phmschools.org/dream-commission-society";
            case R.id.textView5:
                return "https://penn.phmschools.org/chess-club";
            case R.id.textView6:
                return "https://penn.phmschools.org/chinese-club";
            case R.id.textView7:
                return "https://penn.phmschools.org/composers-forum";
            case R.id.textView8:
                return "https://penn.phmschools.org/computer-club";
            case R.id.textView9:
                return "https://penn.phmschools.org/deca";
            case R.id.textView10:
                return "https://penn.phmschools.org/dream-commission-society";
            case R.id.textView11:
                return "https://penn.phmschools.org/drones-and-remote-sensing-rc-club";
            case R.id.textView12:
                return "https://penn.phmschools.org/doctor-who-club";
            case R.id.textView13:
                return "https://penn.phmschools.org/economics-investing-club";
            case R.id.textView14:
                return "https://penn.phmschools.org/facs-club";
            case R.id.textView15:
                return "https://penn.phmschools.org/fellowship-christian-athletes";
            case R.id.textView16:
                return "http://team135.org/";
            case R.id.textView17:
                return "https://penn.phmschools.org/french-club";
            case R.id.textView18:
                return "https://penn.phmschools.org/friends-library";
            case R.id.textView19:
                return "https://penn.phmschools.org/ffa";
            case R.id.textView20:
                return "https://penn.phmschools.org/game-club";
            case R.id.textView21:
                return "https://penn.phmschools.org/gay-straight-alliance";
            case R.id.textView22:
                return "https://penn.phmschools.org/german-club";
            case R.id.textView23:
                return "https://penn.phmschools.org/habitat-humanity";
            case R.id.textView24:
                return "https://penn.phmschools.org/handwritten-hearts-club";
            case R.id.textView25:
                return "http://www.pennhockey.com/home.html";
            case R.id.textView26:
                return "https://penn.phmschools.org/i-ball-intramural-basketball";
            case R.id.textView27:
                return "https://penn.phmschools.org/intramural-volleyball";
            case R.id.textView28:
                return "https://penn.phmschools.org/japanese-club";
            case R.id.textView29:
                return "https://penn.phmschools.org/jrotc-club";
            case R.id.textView30:
                return "https://penn.phmschools.org/key-club";
            case R.id.textView31:
                return "https://penn.phmschools.org/kingsmen-against-cancer";
            case R.id.textView32:
                return "https://penn.phmschools.org/kingsmen-court";
            case R.id.textView33:
                return "https://penn.phmschools.org/kingsmen-fight-against-diabetes";
            case R.id.textView34:
                return "https://penn.phmschools.org/korean-club";
            case R.id.textView35:
                return "http://kingsmenlacrosse.com/";
            case R.id.textView36:
                return "https://penn.phmschools.org/national-honor-society";
            case R.id.textView37:
                return "https://penn.phmschools.org/p7-bible-club";
            case R.id.textView38:
                return "https://penn.phmschools.org/penn-medical-club";
            case R.id.textView39:
                return "http://pnn.phmschools.org/about-2/";
            case R.id.textView40:
                return "http://penn.phmschools.org/penn-political-coalition";
            case R.id.textView41:
                return "https://sites.google.com/a/phm.k12.in.us/penn-strength/";
            case R.id.textView42:
                return "https://pennvetclub.wordpress.com/";
            case R.id.textView43:
                return "https://penn.phmschools.org/powder-puff-football";
            case R.id.textView44:
                return "https://penn.phmschools.org/relay-life";
            case R.id.textView45:
                return "https://penn.phmschools.org/sadd-students-against-destructive-decisions";
            case R.id.textView46:
                return "https://penn.phmschools.org/salt-and-light";
            case R.id.textView47:
                return "https://penn.phmschools.org/science-research-club";
            case R.id.textView48:
                return "https://penn.phmschools.org/spanish-club";
            case R.id.textView49:
                return "https://penn.phmschools.org/technology-students-association";
            case R.id.textView50:
                return "https://penn.phmschools.org/theatre-club";
            case R.id.textView51:
                return "https://penn.phmschools.org/ultimate-frisbee-club";
            case R.id.textView52:
                return "https://sites.google.com/site/thegreatwritersguild2/";
            case R.id.textView53:
                return "https://penn.phmschools.org/24-hour-theatertalent-show";

            default:
                return "error";
        }
        //return null;
    }
    public void onClick(View v) {
        String url = parser(v);
        if (url=="error"){
            Toast.makeText(clubActivity.this, "An unexpected error occured, please try again", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        Builder builder = new Builder();
        builder.setToolbarColor(Color.DKGRAY);
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }
}
