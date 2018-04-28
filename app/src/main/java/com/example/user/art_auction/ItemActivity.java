package com.example.user.art_auction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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
import java.util.HashMap;
import java.util.Map;

public class ItemActivity extends AppBasicMenuActivity {
    AuctionItem aucItem;

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auctionitem);

        Bundle b = getIntent().getExtras();
        aucItem = (AuctionItem)b.get("AuctionItem");

        final TextView itemName= (TextView) findViewById(R.id.itemName);
        final TextView itemDesc = (TextView) findViewById(R.id.itemDesc);
        final TextView itemPrice = (TextView) findViewById(R.id.itemPr);
        final ImageView image = (ImageView) findViewById(R.id.my_item_image);

        itemName.setText(aucItem.getName());
        itemDesc.setText(aucItem.getDescription());
        itemPrice.setText(String.valueOf(aucItem.getMinimumPrice()));

        RestAsyncCaller.getAuctionItemImage(ItemActivity.this, aucItem.getAuction(), aucItem, image);

    }

    public void makeBid(View view) {
        String url = "http://10.0.2.2:8080/auction/" + aucItem.getAuction().getId() + "/" + aucItem.getId() + "/bid";
        final EditText tv = (EditText)findViewById(R.id.bid_price);
        final StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Intent myIntent = new Intent(ItemActivity.this, UserBidsActivity.class);
                        startActivity(myIntent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String body = "";
                try {
                    if (error.networkResponse.data != null)
                        body = new String(error.networkResponse.data, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Toast.makeText(ItemActivity.this, "Error" + body + "\nWTF", Toast.LENGTH_LONG).show();
            }


        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params2 = new HashMap<String, String>();
                params2.put("userId", UserSessionSingleton.getInstance(ItemActivity.this).getSessionId());
                params2.put("price", tv.getText().toString());
                return  params2;
            }


        };
        RequestQueueSingleton.getInstance(ItemActivity.this).addToRequestQue(request);
    }
}