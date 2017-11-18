package com.example.user.art_auction;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by USER on 28/10/2017.
 */

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class ServerRestConsumer {

    public ServerRestConsumer(Context context){
        requestQueue = Volley.newRequestQueue(context);
        requestQueue.start();
    }

    private RequestQueue requestQueue;
    private static String baseUrl = "http://10.0.2.2:8080";

    public String signUp(){
        return null;
    }

    public String signIn(){
        return null;
    }

    public boolean addAuction(){
        return false;
    }

    public boolean addAuctionItem(){
        return false;
    }

    public ArrayList<String> getAuctionItems(){
        return null;
    }

    public ArrayList<String> getMyBids(){
        return null;
    }

    public ArrayList<String> getMyAuctions(){
        return null;
    }

    public RequestFuture<JSONArray> getAuctionsList() {
        String url = this.baseUrl + "/auction/all";
        /*JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray  response) {
                VolleyLog.v("Response:%n %s", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });*/
        RequestFuture<JSONArray> future = RequestFuture.newFuture();
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, "", future, future);


        requestQueue.add(request);

        return future;
    }

}
