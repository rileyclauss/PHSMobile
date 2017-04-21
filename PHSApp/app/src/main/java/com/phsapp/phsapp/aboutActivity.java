package com.phsapp.phsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class aboutActivity extends AppCompatActivity {
int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(aboutActivity.this, "it loads again", Toast.LENGTH_SHORT ).show();
        if (i==0){
                super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);}
        i++;
    }
}
