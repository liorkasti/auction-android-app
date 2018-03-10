package com.example.user.art_auction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;


import java.io.Serializable;


public class AuctionItem implements Serializable {
        private long id;
        private String name;
        private String description;
        private int minimumPrice;
        private String promtBid;

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
    }
