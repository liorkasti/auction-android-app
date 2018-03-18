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

    Button bt1, bt2, bt3, bt_add_auction, bt_add_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ServerRestConsumer rest = new ServerRestConsumer(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate");

        //        userName = (EditText) findViewById(R.id.userName);
        //        dataView = (TextView) findViewById(R.id.userName);
        //        editor.putString("userName", LogInActivity.userName.getText().toString());
        //        String msg = "Hello: " + name;

        bt1 = (Button) findViewById(R.id.guest_btn);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(myIntent);
            }
        });
        bt_add_auction = (Button) findViewById(R.id.sign_in_btn);
        bt_add_auction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddAuctionActivity.class);
                startActivity(myIntent);
            }
        });
        bt3 = (Button) findViewById(R.id.sign_up_btn);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(myIntent);
            }
        });
        Button bt4 = (Button) findViewById(R.id.test_rest);
        bt4.setOnClickListener(new View.OnClickListener() {
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

        bt_add_item = (Button) findViewById(R.id.add_item_btn);
        bt_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddAuctionItemActivity.class);
                startActivity(myIntent);
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

                Intent myIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level3: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(MainActivity.this, AddUserActivity.class);
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

                Intent myIntent = new Intent(MainActivity.this, ItemActivity.class);
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

            case R.id.menu_level9: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

//                Intent myIntent = new Intent(MainActivity.this, );
//                startActivity(myIntent);
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
