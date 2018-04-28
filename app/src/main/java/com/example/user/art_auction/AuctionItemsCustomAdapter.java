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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
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

class AuctionItemsCustomAdapter extends ArrayAdapter<AuctionItem> {

    public AuctionItemsCustomAdapter(Context context, AuctionItem[] auctions) {
        super(context, R.layout.auction_item_row, auctions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // default -  return super.getView(position, convertView, parent);
        // add the layout
        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.auction_item_row, parent, false);
        // get references.
        AuctionItem singleAuctionItem = getItem(position);
        TextView itemText = (TextView) customView.findViewById(R.id.item_name_tv);
        // dynamically update the text from the array
        itemText.setText(singleAuctionItem.getName());

        Button b1 = (Button) customView.findViewById(R.id.item_enter_btn);
        b1.setTag(singleAuctionItem);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuctionItem a = (AuctionItem)v.getTag();
                Intent myIntent = new Intent(v.getContext(), ItemActivity.class);
                myIntent.putExtra("AuctionItem", a);
                v.getContext().startActivity(myIntent);
            }
        });


        ImageView auctionImage = (ImageView) customView.findViewById(R.id.hp_main_image);
        // using the same image every time
        //getAuctionItemImage()
        auctionImage.setImageResource(R.drawable.art10);
        RestAsyncCaller.getAuctionItemImage(getContext(), singleAuctionItem.getAuction(), singleAuctionItem, auctionImage);
        // Now we can finally return our custom View or custom item
        return customView;
    }


}
