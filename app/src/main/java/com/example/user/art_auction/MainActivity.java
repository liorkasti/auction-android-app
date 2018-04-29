// 17.8.17 14:24
package com.example.user.art_auction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
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

public class MainActivity extends AppBasicMenuActivity {

    private static final String TAG = "Messeges";

    EditText userNameET;

    Button bt_go_to_auctions, bt2, bt_log_in, bt_add_auction, bt_add_item, bt_test_rest, bt_my_active_auctions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ServerRestConsumer rest = new ServerRestConsumer(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.i(TAG, "onCreate");

        userNameET = (EditText) findViewById(R.id.userNameMainET);
        Intent incomingIntent = getIntent();
//        set the userName
        String MSGuserName = incomingIntent.getStringExtra("userName");
        if (MSGuserName == null) {
        } else {
            MSGuserName = "Hello: " + incomingIntent.getStringExtra("userName");
            userNameET.setText(MSGuserName);
        }
        bt_go_to_auctions = (Button) findViewById(R.id.guest_btn);
        bt_go_to_auctions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AuctionsGalleryActivity.class);
                startActivity(myIntent);
            }
        });

//        String MSGuserName = getData(rest);
//        if (UserSessionSingleton.getInstance(MainActivity.this).isLoggedIn()) {
//        } else {
//            MSGuserName = "Hello: " + MSGuserName;
//            Log.i(TAG, "userName: " + MSGuserName);
//            userNameET.setText(MSGuserName);
//        }


//        bt_add_item = (Button) findViewById(R.id.add_item_btn);
//        bt_add_item.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(MainActivity.this, AddAuctionItemActivity.class);
//                myIntent.putExtra("auctionId", "1");
//                startActivity(myIntent);
//            }
//        });


//        bt_add_auction = (Button) findViewById(R.id.add_auction_btn);
//        bt_add_auction.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(MainActivity.this, AddAuctionActivity.class);
//                startActivity(myIntent);
//            }
//        });


        bt_log_in = (Button) findViewById(R.id.log_in_btn);
        bt_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(myIntent);
            }
        });


//        bt_test_rest = (Button) findViewById(R.id.test_rest_btn);
//        bt_test_rest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent myIntent = new Intent(MainActivity.this, AddAuctionActivity.class);
////                startActivity(myIntent);
//            }
//        });

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


//    protected String getData(final ServerRestConsumer ctx) {
//        String url = "http://10.0.2.2:8080/user/";
//        final StringRequest request = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        //set the id from response as session id
//                        JSONObject jsonResponse = null;
//                        ObjectMapper mapper = new ObjectMapper();
//                        try {
//                            JSONArray contacts = new JSONArray(response);
//                            ArrayList<User> users = new ArrayList<>();
//                            // looping through All Contacts
//                            for (int i = 0; i < contacts.length(); i++) {
//                                JSONObject c = contacts.getJSONObject(i);
//                                User obj = mapper.readValue(c.toString(), User.class);
//
//                                users.add(obj);
//
//                            }
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        } catch (JsonParseException e) {
//                            e.printStackTrace();
//                        } catch (JsonMappingException e) {
//                            e.printStackTrace();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
////                        String rest = rest.setUser().getFistName();
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                String body = "";
//                try {
//                    body = new String(error.networkResponse.data, "UTF-8");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        RequestQueueSingleton.getInstance(MainActivity.this).addToRequestQue(request);
//
//        return rest;
//    }

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
