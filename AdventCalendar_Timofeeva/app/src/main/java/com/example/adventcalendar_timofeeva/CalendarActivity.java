package com.example.adventcalendar_timofeeva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;

public class CalendarActivity extends AppCompatActivity {

    public TextView currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        currentDate = (TextView) findViewById(R.id.now);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        currentDate.setText(currentDay);
    }

    public void toDay(View view) {
        Data.curDay = ((Button) view).getText().toString();
        Intent intent = new Intent(this, CurrentDayActivity.class);
        startActivity(intent);
    }
}