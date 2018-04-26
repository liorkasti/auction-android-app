package com.example.user.art_auction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import org.json.JSONArray;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by user on 24/10/2017.
 */

public class MyUserActivity extends AppBasicMenuActivity {


    private static final String TAG = "Messeges";

    EditText userName;

    Button bt_acount_info, bt_go_to_auctions, bt_user_history, bt_my_active_auctions, bt_add_auction, bt_add_item, bt_log_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ServerRestConsumer rest = new ServerRestConsumer(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_account_activity);


        bt_add_item = (Button) findViewById(R.id.add_item_btn);
        bt_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MyUserActivity.this, AddAuctionItemActivity.class);
                startActivity(myIntent);
            }
        });


        bt_add_auction = (Button) findViewById(R.id.add_auction_btn);
        bt_add_auction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MyUserActivity.this, AddAuctionActivity.class);
                startActivity(myIntent);
            }
        });

        bt_go_to_auctions = (Button) findViewById(R.id.all_auctions_btn);
        bt_go_to_auctions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MyUserActivity.this, AuctionsActivity.class);
                startActivity(myIntent);
            }
        });

        bt_user_history = (Button) findViewById(R.id.history_btn);
        Log.i(TAG, "bt_user_history");
        bt_user_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "getUserAuctionItems");

                Intent myIntent = new Intent(MyUserActivity.this, UserHistoryActivity.class);
                startActivity(myIntent);
            }
        });

        bt_my_active_auctions = (Button) findViewById(R.id.active_auction_btn);
        Log.i(TAG, "bt_my_active_auctions");
        bt_my_active_auctions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "getUserAuctionItems");

                Intent myIntent = new Intent(MyUserActivity.this, UserBidsActivity.class);
                startActivity(myIntent);
            }
        });

/*
        userName = (EditText) findViewById(R.id.userName);
        Intent incomingIntent = getIntent();
//        set the userName
        String MSGuserName = incomingIntent.getStringExtra("userName");
        if (MSGuserName == null) {
        } else {
            MSGuserName = "Hello: " + incomingIntent.getStringExtra("userName");
            userName.setText(MSGuserName);
        }
        bt_go_to_auctions = (Button) findViewById(R.id.guest_btn);
        bt_go_to_auctions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MyUserActivity.this, AuctionsActivity.class);
                startActivity(myIntent);
            }
        });


        bt_add_item = (Button) findViewById(R.id.add_item_btn);
        bt_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MyUserActivity.this, AddAuctionItemActivity.class);
                startActivity(myIntent);
            }
        });


        bt_add_auction = (Button) findViewById(R.id.add_auction_btn);
        bt_add_auction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MyUserActivity.this, AddAuctionActivity.class);
                startActivity(myIntent);
            }
        });


        bt_log_in = (Button) findViewById(R.id.log_in_btn);
        bt_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MyUserActivity.this, LogInActivity.class);
                startActivity(myIntent);
            }
        });*/


    }
}