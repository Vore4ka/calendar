package com.example.adventcalendar_timofeeva;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    public TextView userName, currentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (TextView) findViewById(R.id.userName);
        userName.setText(Data.userName);
        currentDate = (TextView) findViewById(R.id.day);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        currentDate.setText(currentDay);
    }

    public void toCalendar(View view) {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    public void changeUserNameAction (View view) {
        final EditText input = new EditText(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Изменение имени пользователя");
        builder.setMessage("Введите свое имя");
        builder.setView(input);
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Отменено", Toast.LENGTH_LONG).show();
            }
        });
        builder.setPositiveButton("Подтверждено", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(input.getText().length() != 0) {
                    Data.userName = input.getText().toString();
                    userName = (TextView) findViewById(R.id.userName);
                    userName.setText(Data.userName);
                    Toast.makeText(getApplicationContext(), "Вы изменили имя на " + Data.userName, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Имя не было изменено", Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.show();
    }
}