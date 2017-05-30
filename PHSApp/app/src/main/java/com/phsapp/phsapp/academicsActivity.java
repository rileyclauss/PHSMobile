package com.phsapp.phsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class academicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academics);
        Toast.makeText(this, "Click any button for more information.", Toast.LENGTH_LONG).show();

        //@TODO Make Buttons activate each link

    }

    protected void onClick(View v){
        String url = "";
        char target = (v.getTag().toString().charAt(0));
        switch (target) {
            case 'a':
                url = "https://penn.phmschools.org/testing-dates";
                break;
            case 'b':
                url = "https://penn.phmschools.org/program-studies";
                break;
            case 'c':
                url = "https://penn.phmschools.org/alternative-education-0";
                break;
            case 'd':

        }
    }
}
