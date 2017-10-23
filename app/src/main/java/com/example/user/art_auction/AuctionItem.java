package com.example.user.art_auction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class AuctionItem extends AppCompatActivity {
    private long id;
    private String name;
    private String description;
    private int minimumPrice;
    private String promtBid;

    //list of bidders?

    public AuctionItem() {

    }

    public AuctionItem(long id, String name, String description, int minimumPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minimumPrice = minimumPrice;
        this.promtBid = "YOUR BID SUCCESS";

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(int minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity);

//        itemName = (EditText) findViewById(R.id.name);
//        itemDescription = (EditText) findViewById(R.id.description);
//        itemBid = (TextView) findViewById(R.id.promtBid);

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

                Intent myIntent = new Intent(AuctionItem.this, HomeActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level2: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AuctionItem.this, AuctionItem.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level3: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AuctionItem.this, SignUpActivity.class);
                startActivity(myIntent);
                return true;
            }


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
