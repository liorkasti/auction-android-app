package com.example.user.art_auction;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by user on 13/10/2017.
 */

@SuppressWarnings("serial")
class Auction implements Serializable{

        private long id;
        private String title;
        private String description;
//        private String type;
        private Date startAuction;
        private Date endAuction;
        private AuctionItemImage image;

        //list of bidders?


        public Auction() {

        }

        public Auction(long id, String title, String description, Date startAuction, Date endAuction) {
                this.id = id;
                this.title = title;
                this.description = description;
                this.startAuction = startAuction;
                this.endAuction = endAuction;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Date getStartAuction() {
                return startAuction;
        }

        public void setStartAuction(Date startAuction) {
                this.startAuction = startAuction;
        }

        public Date getEndAuction() {
                return endAuction;
        }

        public void setEndAuction(Date endAuction) {
                this.endAuction = endAuction;
        }

        public AuctionItemImage getImage() {
                return image;
        }

        public void setImage(AuctionItemImage image) {
                this.image = image;
        }
}
