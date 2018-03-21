package com.example.user.art_auction;


        import android.app.Dialog;
        import android.app.TimePickerDialog;
        import android.os.Bundle;
        import android.support.v4.app.DialogFragment;
        import android.text.format.DateFormat;
        import android.widget.TextView;
        import android.widget.TimePicker;

        import java.util.Calendar;

/**
 * Created by user on 21/03/2018.
 */

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState){
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, min,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // time chosen by the user
        TextView tv1 = (TextView) getActivity().findViewById(R.id.tvStartTime);
        String time = "";
        if (hourOfDay < 10){
            time = "0";
        }
        time += hourOfDay + ":";
        if (minute < 10){
            time += "0";
        }
        time += minute;

        tv1.setText(time);

    }
}