package com.example.adventcalendar_timofeeva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;

public class CurrentDayActivity extends AppCompatActivity {

    public TextView currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_day);
        currentDate = (TextView) findViewById(R.id.today);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        currentDate.setText(currentDay);
    }


}