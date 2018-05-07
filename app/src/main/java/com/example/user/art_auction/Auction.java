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
        private Date startAuction;
        private Date endAuction;
        private String auctionType;
        private String imageUrl;
        private User owner;
        private boolean silentAuction;



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

        public String getAuctionType() {
                return auctionType;
        }

        public void setAuctionType(String auctionType) {
                this.auctionType = auctionType;
        }

        public String getImageUrl() {
                return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
        }

        public User getOwner() {
                return owner;
        }

        public void setOwner(User owner) {
                this.owner = owner;
        }

        public boolean isSilentAuction() {
                return silentAuction;
        }

        public void setSilentAuction(boolean silentAuction) {
                this.silentAuction = silentAuction;
        }
}
