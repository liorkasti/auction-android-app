package com.example.user.art_auction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 19/10/2017.
 */

class ItemAdapter extends ArrayAdapter<String> {
    public ItemAdapter(Context context, String[] foods) {
        super(context, R.layout.custom_row, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View itemView = myCustomInflater.inflate(R.layout.item_view_row, parent, false);
        // get references.
        String item_description1 = "This Is The Item Description For Exampel";
//        String item_description = AuctionItem.getDescription(position);

        String singlePicItem = getItem(position);
//        TextView itemText = (TextView) item_view_row.findViewById(R.id.item_text);
//        Button b1 = (Button) item_view_row.findViewById(R.id.enter_btn);
//        Button b2 = (Button) item_view_row.findViewById(R.id.sign_up_btn);
        ImageView auctionImage = (ImageView) itemView.findViewById(R.id.my_item_image);

//        EditText description = (EditText) item_view_row.findViewById(R.id.item_description);

//        item_description.setText(item_description1);

//        itemText.setText(singlePicItem);
        auctionImage.setImageResource(R.drawable.art11);
        return itemView;
    }
}