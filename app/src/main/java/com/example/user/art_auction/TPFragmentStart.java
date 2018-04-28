package com.example.user.art_auction;


        import android.app.Dialog;
        import android.app.TimePickerDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.DialogFragment;
        import android.text.format.DateFormat;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import android.widget.TimePicker;

        import java.util.Calendar;

/**
 * Created by user on 21/03/2018.
 */

public class TPFragmentStart extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    private static final String TAG = "Messeges";
//    private String valToPass;

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_add_auction,container, false);
//        return view;
//    }

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
        Log.i(TAG, "TPFragmentStart HH:mm---------------endTime " + time);

//        valToPass = time;
//        //INTENT OBJ
//        Intent i = new Intent(getActivity().getBaseContext(),
//                AddAuctionActivity.class);
//
//        //PACK DATA
//        Intent intent = i.putExtra("valToPass", valToPass);
//
//        //START ACTIVITY
//        getActivity().startActivity(i);
    }

}