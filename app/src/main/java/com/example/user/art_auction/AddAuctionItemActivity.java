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

public class AddAuctionItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_auction_item);
    }

    public void addItem(final View view) {
        final EditText itemName= (EditText) findViewById(R.id.itemName);
        final EditText itemDesc = (EditText) findViewById(R.id.itemDesc);
        final EditText itemPrice = (EditText) findViewById(R.id.itemPrice);

        String url = "http://10.0.2.2:8080/{auctionid}/add"; //todo this

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //set the id from response as session id
                        UserSessionSingleton.getInstance(AddAuctionItemActivity.this).loginUser(response);
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
                params2.put("title", itemName.getText().toString());
                params2.put("description", itemDesc.getText().toString());
                params2.put("price", itemPrice.getText().toString());
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
        RequestQueueSingleton.getInstance(AddAuctionItemActivity.this).addToRequestQue(request);

        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }
}