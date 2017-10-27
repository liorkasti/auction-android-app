package com.example.user.art_auction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {


    EditText userName;
    EditText password;
    TextView dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        userName = (EditText) findViewById(R.id.userNameInput);
        password = (EditText) findViewById(R.id.passwordInput);
        dataView = (TextView) findViewById(R.id.dataTextView);

    }

    // Lesson 64
    //Save login info
    public void saveData(View view) {
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginData.edit();
        editor.putString("userName", userName.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }

    public void getData(View view) {
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = loginData.getString("userName", "");
        String pw = loginData.getString("password", "");
        String msg = "Saved User Name: " + name + "\nSaved Password: " + pw;
        dataView.setText(msg);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_view = (RelativeLayout) findViewById(R.id.main_view);

        switch (item.getItemId()) {
            case R.id.menu_level1: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level2: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(SignUpActivity.this, HomeActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level3: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(SignUpActivity.this, SignUpActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.menu_level4: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(SignUpActivity.this, MyAccountActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.menu_level5: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(SignUpActivity.this, ItemActivity.class);
                startActivity(myIntent);
                return true;
            }
//            case R.id.menu_level6: {
//                if (item.isChecked())
//                    item.setChecked(false);
//                else
//                    item.setChecked(true);
//
//                Intent myIntent = new Intent(SignUpActivity.this, Exit.class);
//                startActivity(myIntent);
//                return true;
//            }


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}