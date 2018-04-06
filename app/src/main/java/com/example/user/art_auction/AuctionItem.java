package com.example.user.art_auction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;


import java.io.Serializable;
import java.util.Set;


public class AuctionItem implements Serializable {
        private long id;
        private String name;
        private String description;
        private int minimumPrice;
        private Auction auction;
        private Set<AuctionItemImage> images;

    public AuctionItem(){

    }

    public AuctionItem(Auction a, long id, String name, String description, int minimumPrice) {
            this.id = id;
            this.setAuction(a);
            this.name = name;
            this.description = description;
            this.minimumPrice = minimumPrice;
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

    public Set<AuctionItemImage> getImages() {
        return images;
    }

    public void setImages(Set<AuctionItemImage> images) {
        this.images = images;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
