package com.example.user.art_auction;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;

/**
 * Created by user on 14/03/2018.
 */

class CalendarActivity extends AppBasicMenuActivity{

    private static final String TAG = "Messeges";

    private CalendarView    mCalenderView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);

        mCalenderView = (CalendarView) findViewById(R.id.calendarView);

        mCalenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String date = "";
                if (dayOfMonth < 10){
                    date = "0";
                }
                date += dayOfMonth + "-";
                if (month < 9){
                    date += "0";
                }
                date += (month+1) + "-" + year;

                Log.i(TAG, "onSelectedDayChange: dd-mm-yyyy: " + date);

                Intent returnIntent = new Intent(CalendarActivity.this, AddAuctionActivity.class);
                returnIntent.putExtra("date",date);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });

    }
}
