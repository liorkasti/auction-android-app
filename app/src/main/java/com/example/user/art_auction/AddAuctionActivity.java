package com.example.user.art_auction;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AddAuctionActivity extends AppCompatActivity {

    private static final String TAG = "Messeges";

    Date _startDate;
    Date _endDate;

    private TextView tvStartDate;
    private Button btnGoToCalander;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_auction);

        tvStartDate = (TextView) findViewById(R.id.tvStartDate);
        btnGoToCalander = (Button) findViewById(R.id.btnGoToCalander);

        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        tvStartDate.setText(date);

        btnGoToCalander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "ListenerGoToCalander");
                Intent intent = new Intent(AddAuctionActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });
    }


    public void addAuction(final View view) {
        final EditText auctionName = (EditText) findViewById(R.id.auctionName);
        final EditText auctionDesc = (EditText) findViewById(R.id.auctionDesc);

        String url = "http://10.0.2.2:8080/auction/add";

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //set the id from response as session id
                        UserSessionSingleton.getInstance(AddAuctionActivity.this).loginUser(response);
                        Toast.makeText(view.getContext(), "ok " + response, Toast.LENGTH_LONG);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String body = "";
                try {
                    body = new String(error.networkResponse.data, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Toast.makeText(view.getContext(), "Error" + body, Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params2 = new HashMap<String, String>();
                params2.put("title", auctionName.getText().toString());
                params2.put("description", auctionDesc.getText().toString()); //todo: add user ID, get auction id
                //params2.put("email", userName.getText().toString());
                //params2.put("password", password.getText().toString());
                return params2;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }
        };
        RequestQueueSingleton.getInstance(AddAuctionActivity.this).addToRequestQue(request);

        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }

    public void addAuctionStartDate(View view) {
        setDate(view.getId());
    }

    private void setDate(final int id) {
        LayoutInflater inflater = AddAuctionActivity.this.getLayoutInflater();
        AlertDialog.Builder bl = new AlertDialog.Builder(AddAuctionActivity.this);
        bl.setView(inflater.inflate(R.layout.datetime_layout, null))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Calendar c = Calendar.getInstance();
                        TimePicker tp = (TimePicker) ((Dialog) dialog).findViewById(R.id.timePicker1);
                        DatePicker dp = (DatePicker) ((Dialog) dialog).findViewById(R.id.datePicker1);
                        c.set(Calendar.DAY_OF_MONTH, dp.getDayOfMonth());
                        c.set(Calendar.MONTH, dp.getMonth());
                        c.set(Calendar.YEAR, dp.getYear());
                        c.set(Calendar.HOUR_OF_DAY, tp.getCurrentHour());
                        c.set(Calendar.MINUTE, tp.getCurrentMinute());
                        TextView tv = (TextView) AddAuctionActivity.this.findViewById(id);
                        tv.setText(c.getTime().toString());
                    }
                });
        bl.create().show();
    }
}
