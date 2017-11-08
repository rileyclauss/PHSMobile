package com.phsapp.phsapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

//@TODO Read events from [source]
//@TODO Make days with events different from days without events
//@TODO Show Upcoming events on the bottom of the screen
//@TODO Tap on an event to view information about it
public class calendarActivity extends AppCompatActivity  {
    MaterialCalendarView calendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = (MaterialCalendarView) findViewById(R.id.calendarView);


    }
}