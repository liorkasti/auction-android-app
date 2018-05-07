package com.example.user.art_auction;

import java.io.Serializable;
import java.util.Date;

public class ItemBid implements Serializable {
	private long id; 
	private User bidder;
	private AuctionItem auctionItem;
	private int bidPrice;
	private Date bidTs; 
}
