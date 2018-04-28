package com.example.user.art_auction;


import android.content.Context;
import android.os.Bundle;
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
import java.util.Date;


public class UserBidsActivity extends AppBasicMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_bids_activity);

        getUserBids(UserBidsActivity.this);
    }
    protected void getUserBids(final Context ctx){
        String userId = UserSessionSingleton.getInstance(UserBidsActivity.this).getSessionId();
        String url = "http://10.0.2.2:8080/user/" + userId + "/bids";
        final StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //set the id from response as session id
                        JSONObject jsonResponse = null;
                        ObjectMapper mapper = new ObjectMapper();
                        try {
                            JSONArray contacts = new JSONArray(response);
                            ArrayList<AuctionItemBid> userBids = new ArrayList<>();
                            // looping through All Contacts
                            for (int i = 0; i < contacts.length(); i++) {
                                JSONObject c = contacts.getJSONObject(i);
                                AuctionItemBid obj = mapper.readValue(c.toString(), AuctionItemBid.class);
                                userBids.add(obj);
                            }
                            ListAdapter customListAdapter = new UserBidsCustomAdapter(ctx, userBids.toArray(new AuctionItemBid[userBids.size()]));
                            ListView customListView = (ListView) findViewById(R.id.my_bids_ListView);
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
        RequestQueueSingleton.getInstance(UserBidsActivity.this).addToRequestQue(request);
    }
}
