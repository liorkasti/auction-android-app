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

class AuctionItemsCustomAdapter extends ArrayAdapter<AuctionItem> {
    public AuctionItemsCustomAdapter(Context context, AuctionItem[] auctions) {
        super(context, R.layout.hp_row, auctions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // default -  return super.getView(position, convertView, parent);
        // add the layout
        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.hp_row, parent, false);
        // get references.
        AuctionItem singleAuctionItem = getItem(position);
        TextView itemText = (TextView) customView.findViewById(R.id.item_text);
        Button b1 = (Button) customView.findViewById(R.id.enter_btn);
        b1.setTag(singleAuctionItem);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuctionItem a = (AuctionItem)v.getTag();
                //Toast.makeText(v.getContext(), "Hi2" + a.getName(), Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(v.getContext(), ItemActivity.class);
                myIntent.putExtra("AuctionItem", a);
                v.getContext().startActivity(myIntent);
            }
        });
        Button b2 = (Button) customView.findViewById(R.id.sign_up_btn);
        ImageView auctionImage = (ImageView) customView.findViewById(R.id.hp_main_image);


        // dynamically update the text from the array
        itemText.setText(singleAuctionItem.getName());
        // using the same image every time
        //getAuctionItemImage()
        auctionImage.setImageResource(R.drawable.art10);
        getAuctionItemImage(getContext(), singleAuctionItem.getAuction(), singleAuctionItem, auctionImage);
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
