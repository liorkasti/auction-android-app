package com.example.user.art_auction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class AddUserActivity extends AppCompatActivity {


    EditText userName;
    EditText password;
    TextView dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //        userName = (EditText) findViewById(R.id.userName);
//        dataView = (TextView) findViewById(R.id.userName);
//        editor.putString("userName", LogInActivity.userName.getText().toString());
//        String msg = "Hello: " + name;
        userName = (EditText) findViewById(R.id.userNameInput);
        password = (EditText) findViewById(R.id.passwordInput);
        dataView = (TextView) findViewById(R.id.dataTextView);

    }

//    // Lesson 65 (buckey)
//    //Save login info
//    public void addUser(final View view) {
//
//        final userName userNameInput= userName;
//        final password passwordInput = password;
////        final dataView dataView = dataView;
//
//        String url = "http://10.0.2.2:8080/{auctionid}/add"; //todo this
//
//        StringRequest request = new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        //set the id from response as session id
//                        UserSessionSingleton.getInstance(AuctionActivity.this).loginUser(response);
//                        Toast.makeText(view.getContext(), "ok " + response, Toast.LENGTH_LONG);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                String body = "";
//                try {
//                    body = new String(error.networkResponse.data,"UTF-8");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//                Toast.makeText(view.getContext(), "Error" + body, Toast.LENGTH_LONG).show();
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String, String> params2 = new HashMap<String, String>();
//                params2.put("title", userNameInput.getText().toString());
//                params2.put("password", passwordInput.getText().toString());
//                return params2;
//            }
//
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> headers = new HashMap<>();
//                headers.put("Content-Type","application/x-www-form-urlencoded");
//                return headers;
//            }
//        };
//        RequestQueueSingleton.getInstance(AuctionActivity.this).addToRequestQue(request);
//
//        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
//
//        // buckey...
//        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = loginData.edit();
//        editor.putString("userName", userName.getText().toString());
//        editor.putString("password", password.getText().toString());
//        editor.apply();
//
//        String url = "http://10.0.2.2:8080/user/login";
//
//        StringRequest request = new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        //set the id from response as session id
//                        UserSessionSingleton.getInstance(AddUserActivity.this).loginUser(response);
//                        Toast.makeText(view.getContext(), "ok " + response, Toast.LENGTH_LONG);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                String body = "";
//                try {
//                    body = new String(error.networkResponse.data,"UTF-8");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//                Toast.makeText(view.getContext(), "Error" + body, Toast.LENGTH_LONG).show();
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String, String> params2 = new HashMap<String, String>();
//                //params2.put("fName", "Anton");
//                //params2.put("lName", "Lerner");
//                params2.put("email", userName.getText().toString());
//                params2.put("password", password.getText().toString());
//                return params2;
//            }
//
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> headers = new HashMap<>();
//                headers.put("Content-Type","application/x-www-form-urlencoded");
//                return headers;
//            }
//        };
//        RequestQueueSingleton.getInstance(AddUserActivity.this).addToRequestQue(request);
//
//        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
//    }
//
//    public void getData(View view) {
//        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
//        String name = loginData.getString("userName", "");
//        String pw = loginData.getString("password", "");
//        String msg = "Saved User Name: " + name + "\nSaved Password: " + pw;
//        dataView.setText(msg);
//    }
//

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

                Intent myIntent = new Intent(AddUserActivity.this, MainActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level2: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AddUserActivity.this, HomeActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level3: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AddUserActivity.this, SignUpActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.menu_level4: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AddUserActivity.this, MyUserActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.menu_level5: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AddUserActivity.this, ItemActivity.class);
                startActivity(myIntent);
                return true;
            }
//            case R.id.menu_level6: {
//                if (item.isChecked())
//                    item.setChecked(false);
//                else
//                    item.setChecked(true);
//
//                Intent myIntent = new Intent(SignInActivity.this, Exit.class);
//                startActivity(myIntent);
//                return true;
//            }


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}