package com.example.user.art_auction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ArrayList<Auction> auctions = new ArrayList<>();
        auctions.add(new Auction(1, "First Auction", "lalala", Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));

        ListAdapter customListAdapter = new AuctionCustomAdapter(this, auctions.toArray(new Auction[auctions.size()]));// Pass the auction arrary to the constructor.
        ListView customListView = (ListView) findViewById(R.id.hp_ListView);
        customListView.setAdapter(customListAdapter);

        customListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String auctions = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(HomeActivity.this, "Hi", Toast.LENGTH_LONG).show();
                    }
                }
        );

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

                Intent myIntent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level2: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level3: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(HomeActivity.this, SignUpActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.menu_level4: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(HomeActivity.this, MyUserActivity.class);
                startActivity(myIntent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void startMain(View view) {
        Intent myIntent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(myIntent);
    }
}