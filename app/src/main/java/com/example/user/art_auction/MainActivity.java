// 17.8.17 14:24
package com.example.user.art_auction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import org.json.JSONArray;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppBasicMenuActivity{

    private static final String TAG = "Messeges";

    EditText userName;

    Button bt_go_to_auctions, bt2, bt_log_in, bt_add_auction, bt_add_item, bt_test_rest,bt_my_active_auctions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ServerRestConsumer rest = new ServerRestConsumer(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.i(TAG, "onCreate");

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
                Intent myIntent = new Intent(MainActivity.this, AuctionsActivity.class);
                startActivity(myIntent);
            }
        });


        bt_add_item = (Button) findViewById(R.id.add_item_btn);
        bt_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddAuctionItemActivity.class);
                myIntent.putExtra("auctionId", "1");
                startActivity(myIntent);
            }
        });


        bt_add_auction = (Button) findViewById(R.id.add_auction_btn);
        bt_add_auction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddAuctionActivity.class);
                startActivity(myIntent);
            }
        });


        bt_log_in = (Button) findViewById(R.id.log_in_btn);
        bt_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(myIntent);
            }
        });


        bt_test_rest = (Button) findViewById(R.id.test_rest_btn);
        bt_test_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent myIntent = new Intent(MainActivity.this, AddAuctionActivity.class);
//                startActivity(myIntent);
            }
        });

//        bt_my_active_auctions = (Button) findViewById(R.id.active_auction_btn);
//        Log.i(TAG, "onCreate bt_my_active_auctions");
//        bt_my_active_auctions.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "onCreate getUserAuctionItems");
//
//                Intent myIntent = new Intent(MainActivity.this, UserHistoryActivity.class);
//                startActivity(myIntent);
//            }
//        });

    }

    public void getData(View view) {
//        SharedPreferences loginData = LogInActivity.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
//        String name = loginData.getString("userName", "");
//        dataView.setText(msg);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG
                , "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }

}
