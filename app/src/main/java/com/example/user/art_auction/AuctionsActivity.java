package com.example.user.art_auction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
import java.util.Calendar;
import java.util.Date;

public class AuctionsActivity extends AppBasicMenuActivity {


    String timer;
    Date now = new Date();
    Thread t;

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        ArrayList<Auction> auctions = new ArrayList<>();
        final ListAdapter customListAdapter = new AuctionCustomAdapter(this, auctions.toArray(new Auction[auctions.size()]));// Pass the auction arrary to the constructor.
        final ListView customListView = (ListView) findViewById(R.id.hp_ListView);
        customListView.setAdapter(customListAdapter);
        customListView.invalidateViews();

//todo: fix refresh tim
// one way:
//        final Handler handler = new Handler();
//        handler.postDelayed( new Runnable() {
//
//            @Override
//            public void run() {
//                //    customListView.notifyDataSetChanged();
//                customListView.setAdapter(customListAdapter);
//                customListView.invalidateViews();
//                handler.postDelayed( this, 5000 );
//            }
//        }, 5000 );


        getAuctions(this);
        customListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String auctions = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(AuctionsActivity.this, "Hi", Toast.LENGTH_LONG).show();
                    }
                }
        );

        if(UserSessionSingleton.getInstance(AuctionsActivity.this).isLoggedIn()) {
            Button but = (Button) findViewById(R.id.sign_in_button);
            but.setText("My Bids");
            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(AuctionsActivity.this, UserBidsActivity.class);
                    startActivity(myIntent);
                }
            });
        }

    }

    protected void getAuctions(final Context ctx){
        String url = "http://10.0.2.2:8080/auction/all";
        final StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //set the id from response as session id
                        JSONObject jsonResponse = null;
                        ObjectMapper mapper = new ObjectMapper();
                        try {
                            JSONArray contacts = new JSONArray(response);
                            ArrayList<Auction> auctions = new ArrayList<>();
                            // looping through All Contacts
                            for (int i = 0; i < contacts.length(); i++) {
                                JSONObject c = contacts.getJSONObject(i);
                                Auction obj = mapper.readValue(c.toString(), Auction.class);

                                auctions.add(obj);

                            }
                            ListAdapter customListAdapter = new AuctionCustomAdapter(ctx, auctions.toArray(new Auction[auctions.size()]));// Pass the auction arrary to the constructor.
                            ListView customListView = (ListView) findViewById(R.id.hp_ListView);
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
        RequestQueueSingleton.getInstance(AuctionsActivity.this).addToRequestQue(request);
    }

    public void startMain(View view) {
        Intent myIntent = new Intent(AuctionsActivity.this, MainActivity.class);
        startActivity(myIntent);
    }


    public void gotoLogin(View view) {
        Intent myIntent = new Intent(AuctionsActivity.this, LogInActivity.class);
        startActivity(myIntent);
    }
}