package com.example.user.art_auction;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by USER on 28/04/2018.
 */

public class RestAsyncCaller {
    public static void getAuctionItemImage(final Context ctx, Auction a, AuctionItem item, final ImageView auctionImage) {
        String url = "http://10.0.2.2:8080/auction/" + a.getId() + "/" + item.getId() + "/getImage";
        final StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //set the id from response as session id
                        JSONObject jsonResponse = null;
                        ObjectMapper mapper = new ObjectMapper();
                        try {
                            JSONObject imObj= new JSONObject(response);
                            AuctionItemImage obj = mapper.readValue(imObj.toString(), AuctionItemImage.class);
                            Bitmap myBitmap = BitmapFactory.decodeByteArray(obj.getImage(), 0, obj.getImage().length);
                            auctionImage.setImageBitmap(myBitmap);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (JsonParseException e) {
                            auctionImage.setImageResource(R.drawable.art11);
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
        RequestQueueSingleton.getInstance(ctx).addToRequestQue(request);
    }
}
