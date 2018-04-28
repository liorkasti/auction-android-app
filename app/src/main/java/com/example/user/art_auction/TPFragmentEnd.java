package com.example.user.art_auction;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by user on 21/03/2018.
 */

public class TPFragmentEnd extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    private static final String TAG = "Messeges";

    final Calendar c = Calendar.getInstance();
    private int mYear = c.get(Calendar.YEAR);
    private int mMonth = c.get(Calendar.MONTH);
    private int mDay = c.get(Calendar.DAY_OF_MONTH);
    private int mHour = c.get(Calendar.HOUR_OF_DAY);
    private int mMinute = c.get(Calendar.MINUTE);


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, min,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
/*
        // time chosen at least 10 minutes from now
        if (mYear == c.get(Calendar.YEAR)
                && mMonth == c.get(Calendar.MONTH)
                && mDay == c.get(Calendar.DAY_OF_MONTH)
                && (mHour < c.get(Calendar.HOUR_OF_DAY) || (mHour == c.get(Calendar.HOUR_OF_DAY) && mMinute <= (c.get(Calendar.MINUTE) + 10)))
                ) {
//            String body = "";
//            Toast.makeText(this,"Set time at least 10 minutes from now" + body, Toast.LENGTH_LONG).show();
        } else {
*/

        // time chosen by the user
        TextView tv1 = (TextView) getActivity().findViewById(R.id.tvEndTime);
        String time = "";
        if (hourOfDay < 10) {
            time = "0";
        }
        time += hourOfDay + ":";
        if (minute < 10) {
            time += "0";
        }
        time += minute;

        tv1.setText(time);
        Log.i(TAG, "HH:mm---------------endTime " + time);
    }
}
