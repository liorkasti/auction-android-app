package com.example.user.art_auction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class AddAuctionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_auction);
    }

    public void addAuction(final View view) {
        final EditText auctionName= (EditText) findViewById(R.id.auctionName);
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
                    body = new String(error.networkResponse.data,"UTF-8");
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
                headers.put("Content-Type","application/x-www-form-urlencoded");
                return headers;
            }
        };
        RequestQueueSingleton.getInstance(AddAuctionActivity.this).addToRequestQue(request);

        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }
}
