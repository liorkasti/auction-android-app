//package com.example.user.art_auction;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.RelativeLayout;
//
//public class SignInActivity extends AppCompatActivity{
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.item_activity);
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
//                Intent myIntent = new Intent(SignInActivity.this, HomeActivity.class);
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
//                Intent myIntent = new Intent(SignInActivity.this, SignInActivity.class);
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
//                Intent myIntent = new Intent(SignInActivity.this, SignUpActivity.class);
//                startActivity(myIntent);
//                return true;
//            }
//
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//}
//
