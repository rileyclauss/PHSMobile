package com.phsapp.phsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class contactActivity extends AppCompatActivity {


    String [] nameSearch = {"Mr. ", "mr. ", "Mr ", "mr ", "Mrs. ", "mrs. ", "Mrs ", "mrs ", "Miss ", "miss ", "Ms. ", "ms. ", "Ms ", "ms "};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void onClick(View v){
        EditText nameText = (EditText) findViewById(R.id.staffName);
        EditText jobText = (EditText) findViewById(R.id.staffPosition);

        String url = "https://penn.phmschools.org/staff-directory?attribute_1=NAMEVAR&attribute_3=JOBVAR";

        String searchName = nameText.getText().toString();
        String searchJob = jobText.getText().toString();
        searchJob = searchJob.replace(" ", "+");

        for (String targetSearch : nameSearch) {
            searchName = searchName.replace(targetSearch, "");
        }

        url = url.replace("NAMEVAR", searchName);
        url = url.replace("JOBVAR", searchJob);

        customTab.openTab(this, url);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
