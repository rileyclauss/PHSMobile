package com.phsapp.phsapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.api.services.calendar.model.Event;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Date;

//@TODO Read events from [source]
//@TODO Make days with events different from days without events
//@TODO Show Upcoming events on the bottom of the screen
//@TODO Tap on an event to view information about it
public class calendarActivity extends AppCompatActivity  {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        MaterialCalendarView mcv = (MaterialCalendarView) findViewById(R.id.calendarView);
        Date today = new Date();
        mcv.state().edit()
                .setMinimumDate(CalendarDay.from(2016, 9, 1))
                .setMaximumDate(CalendarDay.from(2017, 6, 30))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();
        mcv.setSelectionMode(MaterialCalendarView.SELECTION_MODE_SINGLE);
        Event event = new Event();
    }
}