package com.example.user.art_auction;

/**
 * Created by user on 14/10/2017.
 */

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    private Set<Auction> auctions;

    private Set<AuctionItemBid> bids;

    private Integer id;
    private boolean isAdmin;
    //List of auctions ?
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    private boolean isAdmin() {
        return isAdmin;
    }
    private void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    @JsonIgnore
    public Set<AuctionItemBid> getBids() {
        return bids;
    }
    public void setBids(Set<AuctionItemBid> bids) {
        this.bids = bids;
    }
    @JsonIgnore
    public Set<Auction> getAuctions() {
        return auctions;
    }
    public void setAuctions(Set<Auction> auctions) {
        this.auctions = auctions;
    }
    public Integer getId(){
        return id;
    }

}