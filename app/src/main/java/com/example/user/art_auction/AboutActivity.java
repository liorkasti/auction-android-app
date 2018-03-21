package com.example.user.art_auction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by user on 21/03/2018.
 */

class AboutActivity extends AppBasicMenuActivity {


    private static final String TAG = "Messeges";

    EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ServerRestConsumer rest = new ServerRestConsumer(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Log.i(TAG, "onCreate");

    }
}
