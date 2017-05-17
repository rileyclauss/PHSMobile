package com.phsapp.phsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.NewPennTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTheme(R.style.backgroundtransparent);
    }

    public void onClick(View v){
        if (v.getTag().toString().equals("n")){
            Intent intent = new Intent(this, newsActivity.class);
            startActivity(intent);
        }
        else if (v.getTag().toString().equals("c")){
            Intent intent = new Intent(this, calendarActivity.class);
            startActivity(intent);
        }
        else if (v.getTag().toString().equals("y")){
            Intent intent = new Intent(this, sapActivity.class);
            startActivity(intent);
        }
        else if (v.getTag().toString().equals("a")){
            Intent intent = new Intent(this, academicsActivity.class);
            startActivity(intent);
        }
        else if (v.getTag().toString().equals("o")){
            Intent intent = new Intent(this, counselingActivity.class);
            startActivity(intent);
        }
        else if (v.getTag().toString().equals("t")){
            Intent intent = new Intent(this, athleticsActivity.class);
            startActivity(intent);
        }
        else if (v.getTag().toString().equals("f")){
            Intent intent = new Intent(this, fartsActivity.class);
            startActivity(intent);
        }
        else if (v.getTag().toString().equals("l")){
            Intent intent = new Intent(this, clubActivity.class);
            startActivity(intent);
        }
        else if (v.getTag().toString().equals("z")){
            Intent intent = new Intent(this, staffActivity.class);
            startActivity(intent);
        }
        else if (v.getTag().toString().equals("p")){
            Intent intent = new Intent(this, photogalleryActivity.class);
            startActivity(intent);
        }
        else if (v.getTag().toString().equals("x")){
            Intent intent = new Intent(this, contactActivity.class);
            startActivity(intent);
        }
        else if (v.getTag().toString().equals("u")){
            Intent intent = new Intent(this, aboutActivity.class);
            startActivity(intent);
        }
    }
}