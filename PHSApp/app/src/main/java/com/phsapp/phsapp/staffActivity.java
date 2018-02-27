package com.phsapp.phsapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class staffActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stafflinks);
    }

    public void onClick(View v){
        char target = v.getTag().toString().charAt(0);
        String url = null;
        switch(target){
            case'a':
                url = "https://phm.instructure.com/login/ldap";
                break;
            case'b':
                url = "https://eschoolplus.phmschools.org/TAC/Account/LogOn?ReturnUrl=%2fTAC";
                break;
            case'c':
                url = "https://adminweb.aesoponline.com/access";
                break;
        }
        //customTab.openTab(this, url);
    }
}
