package com.phsapp.phsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class aboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about); //Sets layout to activity_about
    }
    public void onClick(View v){ //Function used by credits_btn
        Toast.makeText(this, "Developed by Riley Clauss and Micah Focht. Art created by James Morris", Toast.LENGTH_LONG).show();
    }
}
