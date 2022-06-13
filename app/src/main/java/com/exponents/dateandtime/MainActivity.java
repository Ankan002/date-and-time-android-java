package com.exponents.dateandtime;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    int date, month, year, hour, minute;
    int myDay, myMonth, myYear, myHour, myMinute;

    Button SelectDate;
    TextView SelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hook();

        actions();
    }

    private void hook(){
        SelectDate = findViewById(R.id.select_date);
        SelectedDate = findViewById(R.id.selected_date);
    }

    public void actions() {
        SelectDate.setOnClickListener(this);
    }

    public void onClick(View view){
        if(view.getId() == R.id.select_date){
            Calendar calender = Calendar.getInstance();

            year = calender.get(Calendar.YEAR);
            month = calender.get(Calendar.MONTH);
            date = calender.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, MainActivity.this, year, month, date);

            datePickerDialog.show();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
        myYear = year;
        myMonth = month;
        myDay = date;

        Calendar calender = Calendar.getInstance();
        hour = calender.get(Calendar.HOUR);
        minute = calender.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, MainActivity.this, hour, minute, DateFormat.is24HourFormat(this));

        timePickerDialog.show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        myHour = hourOfDay;
        myMinute = minute;

        SelectedDate.setText(myDay + "-" + myMonth + "-" + myYear + "   " + myHour + ":" + myMinute);
    }
}