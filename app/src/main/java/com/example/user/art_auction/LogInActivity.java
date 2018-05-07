package com.example.user.art_auction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class LogInActivity extends AppBasicMenuActivity {

    private static final String TAG = "Messeges";

    EditText userName;
    EditText password;
    TextView dataView;
    Button btSignUp, btGoBackToMain;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Log.i(TAG, "onCreate LogInActivity");

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.start();

        userName = (EditText) findViewById(R.id.userNameInput);
        password = (EditText) findViewById(R.id.passwordInput);
        dataView = (TextView) findViewById(R.id.dataTextView);
        btSignUp = (Button) findViewById(R.id.btSignUP);
        Log.i(TAG, "goSignUP");
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(myIntent);
            }
        });
    }

    //Save login info
    public void doLogin(final View view) {
        Log.i(TAG, "doLogin");

        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginData.edit();
        editor.putString("userName", userName.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.apply();
        final ObjectMapper mapper = new ObjectMapper();
        String url = "http://10.0.2.2:8080/user/login";

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //set the id from response as session id
                        //JSONObject c = new JSONObject(response);
                        User obj = null;
                        try {
                            obj = mapper.readValue(response, User.class);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        UserSessionSingleton.getInstance(LogInActivity.this).loginUser(obj.getId().toString());
                        Intent myIntent = new Intent(LogInActivity.this, AuctionsGalleryActivity.class);
                        startActivity(myIntent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String body = "";
                try {
                    if (error.networkResponse.data != null) {
                        body = new String(error.networkResponse.data, "UTF-8");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Toast.makeText(view.getContext(), "Error" + body + "\nUsing MOCK", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params2 = new HashMap<String, String>();
                params2.put("email", userName.getText().toString());
                params2.put("password", password.getText().toString());
                return params2;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }
        };
        RequestQueueSingleton.getInstance(LogInActivity.this).addToRequestQue(request);

        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }

    public void goSignUP(View view) {

        Log.i(TAG, "goSignUP");
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(myIntent);
            }
        });
    }

    public void getData(View view) {

        Log.i(TAG, "getData");
        SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = loginData.getString("userName", "");
        String pw = loginData.getString("password", "");
        String msg = "Saved User Name: " + name + "\nSaved Password: " + pw;
        dataView.setText(msg);
    }
}