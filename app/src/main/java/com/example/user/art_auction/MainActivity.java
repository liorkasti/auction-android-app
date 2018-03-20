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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Messeges";

    EditText userName;

    Button bt_go_to_auctions, bt2, bt_log_in, bt_add_auction, bt_add_item, bt_test_rest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ServerRestConsumer rest = new ServerRestConsumer(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate");

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

                Future<JSONArray> a = rest.getAuctionsList();
                try {
                    JSONArray arr = a.get(2, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
        });


//        bt_add_auction = (Button) findViewById(R.id.add_auction_btn);
//        Log.i(TAG, "add_auction_btn");
//        bt_add_auction.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "add_auction_btn");
//                Intent myIntent = new Intent(MainActivity.this, AddAuctionActivity.class);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_view = (RelativeLayout) findViewById(R.id.main_view);

        switch (item.getItemId()) {
            case R.id.menu_level1: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level2: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(MainActivity.this, AuctionsActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level3: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.menu_level4: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(MainActivity.this, MyUserActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.menu_level5: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(MainActivity.this, AddAuctionItemActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level6: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(MainActivity.this, AddAuctionActivity.class);
                startActivity(myIntent);
                return true;
            }

//            case R.id.menu_level7: {
//                if (item.isChecked())
//                    item.setChecked(false);
//                else
//                    item.setChecked(true);
//
//                Intent myIntent = new Intent(MainActivity.this, LogInActivity.class);
//                startActivity(myIntent);
//                return true;
//            }

//            case R.id.menu_level9: {
//                if (item.isChecked())
//                    item.setChecked(false);
//                else
//                    item.setChecked(true);
//
//                Intent myIntent = new Intent(MainActivity.this, LogInActivity.class); //todo: EXIT
//                startActivity(myIntent);
//                return true;
//            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
