package com.example.calenderdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Timer;

import static android.text.InputType.TYPE_NULL;

public class MainActivity extends AppCompatActivity {

    EditText et_show_date, et_show_time;
    Button btn_set_date, btn_set_time;

    int mdd, mmm, myy, th,tm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_show_date = findViewById(R.id.et_show_date);
        et_show_date.setInputType(TYPE_NULL);
        et_show_time = findViewById(R.id.et_show_time);

        btn_set_date = findViewById(R.id.btn_set_date);
        btn_set_time = findViewById(R.id.btn_set_time);

        btn_set_date.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar obj = Calendar.getInstance();
                mdd = obj.get(Calendar.DAY_OF_MONTH);
                mmm = obj.get(Calendar.MONTH);
                myy = obj.get(Calendar.YEAR);

                DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String ChoosenDate = dayOfMonth+"/"+(month+1)+"/"+year;
                        Toast.makeText(MainActivity.this, "choosen Date ="+ ChoosenDate, Toast.LENGTH_LONG).show();
                        et_show_date.setText(ChoosenDate);
                    }
                }, myy, mmm, mdd);
                dpd.show();
            }
        });

        btn_set_time.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar obj = Calendar.getInstance();
                th = obj.get(Calendar.HOUR_OF_DAY);
                tm = obj.get(Calendar.MINUTE);

                TimePickerDialog tpd = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String CossenTime = hourOfDay+" : "+minute;
                        et_show_time.setText(CossenTime);
                    }
                }, th, tm, true); // true = 24 Hour, false = 12 Hour
                tpd.show();
            }
        });
    }
}