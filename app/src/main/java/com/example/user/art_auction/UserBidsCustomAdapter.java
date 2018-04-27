package com.example.user.art_auction;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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

class UserBidsCustomAdapter extends ArrayAdapter<AuctionItemBid> {
    public UserBidsCustomAdapter(Context context, AuctionItemBid[] auctions) {
        super(context, R.layout.user_bids_row, auctions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // default -  return super.getView(position, convertView, parent);
        // add the layout
        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.user_bids_row, parent, false);
        // get references.
        AuctionItemBid singleUserBidItem = getItem(position);
        TextView itemNameText = (TextView) customView.findViewById(R.id.item_name_text);
        TextView bidDateText = (TextView) customView.findViewById(R.id.bid_date_text);
        TextView itemBidPriceText = (TextView) customView.findViewById(R.id.item_bid_text);

        itemNameText.setText(singleUserBidItem.getAuctionItem().getName());
        bidDateText.setText(singleUserBidItem.getBidTs().toString());
        itemBidPriceText.setText(String.valueOf(singleUserBidItem.getBidPrice()));

        // Now we can finally return our custom View or custom item
        return customView;
    }

    private void getAuctionItemImage(final Context ctx, Auction a, AuctionItem item,final ImageView auctionImage) {
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
        RequestQueueSingleton.getInstance(ctx).addToRequestQue(request);

    }
}
