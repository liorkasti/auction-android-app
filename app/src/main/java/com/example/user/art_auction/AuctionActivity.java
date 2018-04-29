package com.example.user.art_auction;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class AuctionActivity extends AppBasicMenuActivity {

    String timer;
    Date now = new Date();
//    Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auction_activity
        );

        Bundle endTime = getIntent().getExtras();
        if (endTime != null)
        timer = endTime.getString("STRING_End_Date_to_Active_Calc");
        Bundle b = getIntent().getExtras();
        Auction a = (Auction)b.get("Auction");
        getAuctionItems(this.getApplicationContext(), a);
    }

    protected void getAuctionItems(final Context ctx, final Auction a){
        String url = "http://10.0.2.2:8080/auction/" + a.getId() + "/items";
        final StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //set the id from response as session id
                        JSONObject jsonResponse = null;
                        ObjectMapper mapper = new ObjectMapper();
                        try {
                            JSONArray contacts = new JSONArray(response);
                            ArrayList<AuctionItem> auctions = new ArrayList<>();
                            // looping through All Contacts
                            for (int i = 0; i < contacts.length(); i++) {
                                JSONObject c = contacts.getJSONObject(i);
                                AuctionItem obj = mapper.readValue(c.toString(), AuctionItem.class);
                                obj.setAuction(a);
                                auctions.add(obj);
                            }
                            ListAdapter customListAdapter = new AuctionItemsCustomAdapter(ctx, auctions.toArray(new AuctionItem[auctions.size()]));// Pass the auction arrary to the constructor.
                            ListView customListView = (ListView) findViewById(R.id.auction_items_ListView);
                            customListView.setAdapter(customListAdapter);
                            customListView.invalidateViews();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (JsonParseException e) {
                            e.printStackTrace();
                        } catch (JsonMappingException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
                Toast.makeText(ctx, "Error" + body + "\nWTF", Toast.LENGTH_LONG).show();
            }
        });
        RequestQueueSingleton.getInstance(AuctionActivity.this).addToRequestQue(request);
    }

    public void gotoLogin(View view) {
        Intent myIntent = new Intent(AuctionActivity.this, LogInActivity.class);
        startActivity(myIntent);
    }

}
