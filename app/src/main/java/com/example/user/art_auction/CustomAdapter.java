package com.example.user.art_auction;

import android.content.Intent;
import android.widget.Button;

/**
 * Created by user on 19/10/2017.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String> {
    public CustomAdapter(Context context, String[] auctions) {
        super(context, R.layout.hp_row, auctions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // default -  return super.getView(position, convertView, parent);
        // add the layout
        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.hp_row, parent, false);
        // get references.
        String singleAuctionItem = getItem(position);
        TextView itemText = (TextView) customView.findViewById(R.id.item_text);
        Button b1 = (Button) customView.findViewById(R.id.enter_btn);
        Button b2 = (Button) customView.findViewById(R.id.sign_up_btn);
        ImageView auctionImage = (ImageView) customView.findViewById(R.id.hp_main_image);


        // dynamically update the text from the array
        itemText.setText(singleAuctionItem);
        // using the same image every time
        auctionImage.setImageResource(R.drawable.art10);
        // Now we can finally return our custom View or custom item
        return customView;
    }
}