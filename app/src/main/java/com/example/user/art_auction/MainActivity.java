// 17.8.17 14:24
package com.example.user.art_auction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppBasicMenuActivity {

    private static final String TAG = "Messeges";

    EditText userNameET;

    Button bt_go_to_auctions, bt2, bt_log_in, bt_add_auction, bt_add_item, bt_test_rest, bt_my_active_auctions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ServerRestConsumer rest = new ServerRestConsumer(this);

        userNameET = (EditText) findViewById(R.id.userNameMainET);
        Intent incomingIntent = getIntent();
//        set the userName
        String MSGuserName = incomingIntent.getStringExtra("userName");
        if (MSGuserName == null) {
        } else {
            MSGuserName = "Hello: " + incomingIntent.getStringExtra("userName");
            userNameET.setText(MSGuserName);
        }
        bt_go_to_auctions = (Button) findViewById(R.id.guest_btn);
        bt_go_to_auctions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AuctionsGalleryActivity.class);
                startActivity(myIntent);
            }
        });


        bt_log_in = (Button) findViewById(R.id.log_in_btn);
        bt_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(myIntent);
            }
        });

        if (UserSessionSingleton.getInstance(MainActivity.this).isLoggedIn()) {
            bt_go_to_auctions.setText("AUCTIONS");
            bt_log_in.setText("LOGOUT");
            bt_log_in.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(getIntent());
                }
            });
        }

    }


}
