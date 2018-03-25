///*
//package com.example.user.art_auction;
//
//import android.app.Activity;
//import android.app.Dialog;
//import android.app.TimePickerDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.DialogFragment;
//import android.text.format.DateFormat;
//import android.util.Log;
//import android.widget.CalendarView;
//import android.widget.TextView;
//import android.widget.TimePicker;
//
//import java.util.Calendar;
//
//*/
///**
// * Created by user on 14/03/2018.
// *//*
//
//
//class CalendarFragment extends DialogFragment
//        implements TimePickerDialog.OnTimeSetListener {
//
//
//    private static final String TAG = "Messeges";
//
//    private CalendarView    mCalenderView;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//
//
//        @Override
//        public Dialog onCreateDialog (Bundle savedInstanceState){
//            // Use the current time as the default values for the picker
//            final Calendar c = Calendar.getInstance();
//            int hour = c.get(Calendar.HOUR_OF_DAY);
//            int min = c.get(Calendar.MINUTE);
//
//            // Create a new instance of TimePickerDialog and return it
//            return new CalendarDialog(getActivity(), this, hour, min,
//                    DateFormat.is24HourFormat(getActivity()));
//        }
//
//    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//        // time chosen by the user
//        TextView tv1 = (TextView) getActivity().findViewById(R.id.tvStartTime);
//        String time = "";
//        if (hourOfDay < 10){
//            time = "0";
//        }
//        time += hourOfDay + ":";
//        if (minute < 10){
//            time += "0";
//        }
//        time += minute;
//
//        tv1.setText(time);
//    }
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.calendar_layout);
//
//        mCalenderView = (CalendarView) findViewById(R.id.calendarView);
//
//        mCalenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//                String date = "";
//                if (dayOfMonth < 10){
//                    date = "0";
//                }
//                date += dayOfMonth + "-";
//                if (month < 9){
//                    date += "0";
//                }
//                date += (month+1) + "-" + year;
//
//                Log.i(TAG, "onSelectedDayChange: dd-mm-yyyy: " + date);
//
//                Intent returnIntent = new Intent(CalendarFragment.this, AddAuctionActivity.class);
//                returnIntent.putExtra("date",date);
//                setResult(Activity.RESULT_OK,returnIntent);
//                finish();
//            }
//        });
//
//    }
//
//    @Override
//    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//
//    }
//}
//*/
