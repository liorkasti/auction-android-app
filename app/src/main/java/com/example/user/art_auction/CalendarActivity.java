package com.example.user.art_auction;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;
/**
 * Created by user on 14/03/2018.
 */

class CalendarActivity extends AppCompatActivity{

    private static final String TAG = "CalendarActivity";

    private CalendarView mCalenderView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);

        mCalenderView = (CalendarView) findViewById(R.id.calendarView);

        mCalenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                String date = i + "/" + (i1+1) + "/" + i2;
                Log.d(TAG, "onSelectedDayChange: mm/dd/yyyy: " + date);

                Intent intent = new Intent(CalendarActivity.this, AddAuctionActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });

    }
}
