package com.example.user.art_auction;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AuctionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auction_activity);

        Bundle b = getIntent().getExtras();
        Auction a = (Auction)b.get("Auction");

        ArrayList<AuctionItem> items = new ArrayList<>();
        items.add(new AuctionItem(1, "Anton Item", "This is item", 1000));
        items.add(new AuctionItem(2, "Anton Item2", "This is item", 1000));

        ListAdapter customListAdapter = new AuctionItemsCustomAdapter(this, items.toArray(new AuctionItem[items.size()]));// Pass the auction arrary to the constructor.
        ListView customListView = (ListView) findViewById(R.id.auction_items_ListView);
        customListView.setAdapter(customListAdapter);
    }
}
