package com.phsapp.phsapp;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.penntheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTheme(R.style.pennmeme);
    }
    public void newsAct(View v){
        Intent intent = new Intent(this, newsActivity.class);
        startActivity(intent);}
    public void pasAct(View v) {
        Intent intent = new Intent(this, pasActivity.class);
        startActivity(intent);}
    public void calendarAct(View v){
        Intent intent = new Intent(this, calendarActivity.class);
        startActivity(intent);}
     public void counselingAct(View v){
        Intent intent = new Intent(this, counselingActivity.class);
        startActivity(intent);}
     public void academAct(View v) {
         Intent intent = new Intent(this, academicsActivity.class);
         startActivity(intent);}
    public void clubAct(View v) {
        Intent intent = new Intent(this, clubActivity.class);
        startActivity(intent);}
    public void aboutAct(View v){
        Intent intent = new Intent(this, aboutActivity.class);
        startActivity(intent);}
    public void contactAct(View v){
        Intent intent = new Intent(this, contactActivity.class);
        startActivity(intent);}
    public void photoAct(View v){
        Intent intent = new Intent(this, photogalleryActivity.class);
        startActivity(intent);
        }
}

