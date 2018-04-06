package com.example.user.art_auction;

/**
 * Created by user on 13/10/2017.
 */

class AuctionItemImage {
    public AuctionItemImage(Object p0) {
    }

    public AuctionItemImage(){

    }
    private Integer id;
    private String imageUrl;
    private String description;
    private byte[] image;
    private  AuctionItem auctionItem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public AuctionItem getAuctionItem() {
        return auctionItem;
    }

    public void setAuctionItem(AuctionItem auctionItem) {
        this.auctionItem = auctionItem;
    }
}
