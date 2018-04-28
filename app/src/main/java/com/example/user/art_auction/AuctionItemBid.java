package com.example.user.art_auction;

import java.io.Serializable;
import java.util.Date;


public class AuctionItemBid implements Serializable {

	private Integer id; 
	private User bidder;
	private AuctionItem auctionItem;
	private int bidPrice;
	private Date bidTs;

	public AuctionItemBid(){}


	public AuctionItemBid(Integer id, User bidder, AuctionItem auctionItem, int bidPrice, Date bidTs) {
		this.id = id;
		this.bidder = bidder;
		this.auctionItem = auctionItem;
		this.bidPrice = bidPrice;
		this.bidTs = bidTs;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getBidder() {
		return bidder;
	}
	public void setBidder(User bidder) {
		this.bidder = bidder;
	}
	public AuctionItem getAuctionItem() {
		return auctionItem;
	}
	public void setAuctionItem(AuctionItem auctionItem) {
		this.auctionItem = auctionItem;
	}
	public int getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	public Date getBidTs() {
		return bidTs;
	}
	public void setBidTs(Date bidTs) {
		this.bidTs = bidTs;
	}


}
