//package com.example.user.art_auction;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.RelativeLayout;
//import android.widget.Toast;
//
//public class ActionActivity extends AppCompatActivity {
//
//    @Override
//    public boolean onMenuOpened(int featureId, Menu menu) {
//        return super.onMenuOpened(featureId, menu);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.home_activity);
//
//        String[] auctions = {"Dvir - Auction1", "Lior - Auction2", "Anton - Auction3", "Auction4", "Auction5", "Auction6"};
//        // Replace the Array adapter with your custom adapter.
//        // ListAdapter theListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, auctions);
//        ListAdapter customListAdapter = new CustomAdapter(this, auctions);// Pass the auction arrary to the constructor.
//        ListView customListView = (ListView) findViewById(R.id.custom_ListView);
//        customListView.setAdapter(customListAdapter);
//
//        customListView.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        String auctions = String.valueOf(parent.getItemAtPosition(position));
//                        Toast.makeText(ActionActivity.this, auctions, Toast.LENGTH_LONG).show();
//
////                        try {
////                            Class auctionClass = Class.forName("com.exampe.user.art_auction.starting point")
////                            Intent myIntent = new Intent(ActionActivity.this, ActionActivity);
////                            startActivity(auctionClass);
////                        } catch (ClassNotFoundException e) {
////                            e.printStackTrace();
////                        }
//
//                    }
//
//                }
//        );
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        RelativeLayout main_view = (RelativeLayout) findViewById(R.id.main_view);
//
//        switch (item.getItemId()) {
//            case R.id.menu_level1: {
//                if (item.isChecked())
//                    item.setChecked(false);
//                else
//                    item.setChecked(true);
//
//                Intent myIntent = new Intent(ActionActivity.this, MainActivity.class);
//                startActivity(myIntent);
//                return true;
//            }
//
//            case R.id.menu_level2: {
//                if (item.isChecked())
//                    item.setChecked(false);
//                else
//                    item.setChecked(true);
//
//                Intent myIntent = new Intent(ActionActivity.this, ActionActivity.class);
//                startActivity(myIntent);
//                return true;
//            }
//
//            case R.id.menu_level3: {
//                if (item.isChecked())
//                    item.setChecked(false);
//                else
//                    item.setChecked(true);
//
//                Intent myIntent = new Intent(ActionActivity.this, SignUpActivity.class);
//                startActivity(myIntent);
//                return true;
//            }
//            case R.id.menu_level4: {
//                if (item.isChecked())
//                    item.setChecked(false);
//                else
//                    item.setChecked(true);
//
//                Intent myIntent = new Intent(ActionActivity.this, MyAccountActivity.class);
//                startActivity(myIntent);
//                return true;
//            }
////            case R.id.menu_level5: {
////                if (item.isChecked())
////                    item.setChecked(false);
////                else
////                    item.setChecked(true);
////
////                Intent myIntent = new Intent(HomeActivity.this, ItemActivity.class);
////                startActivity(myIntent);
////                return true;
////            }
////            case R.id.menu_level6: {
////                if (item.isChecked())
////                    item.setChecked(false);
////                else
////                    item.setChecked(true);
////
////                Intent myIntent = new Intent(HomeActivity.this, Exit.class);
////                startActivity(myIntent);
////                return true;
////            }
//
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//}