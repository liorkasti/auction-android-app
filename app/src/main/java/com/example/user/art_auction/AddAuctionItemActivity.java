package com.example.user.art_auction;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class AddAuctionItemActivity extends AppCompatActivity {
    String auctionId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_auction_item);
        Bundle b = getIntent().getExtras();
        String value = "";
        if(b != null)
            auctionId= b.getString("auctionId");
    }

    public void addItem(final View view) {
        final EditText itemName= (EditText) findViewById(R.id.itemName);
        final EditText itemDesc = (EditText) findViewById(R.id.itemDesc);
        final EditText itemPrice = (EditText) findViewById(R.id.itemPrice);

        String url = "http://10.0.2.2:8080/" + auctionId.toString() + "/addItem";

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //set the id from response as session id
                        String itemId = response;
                        //UserSessionSingleton.getInstance(AddAuctionItemActivity.this).loginUser(response);

                        Toast.makeText(view.getContext(), "ok " + response, Toast.LENGTH_LONG);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String body = "";
                try {
                    body = new String(error.networkResponse.data,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Toast.makeText(view.getContext(), "Error" + body, Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params2 = new HashMap<String, String>();
                params2.put("title", itemName.getText().toString());
                params2.put("description", itemDesc.getText().toString());
                params2.put("price", itemPrice.getText().toString());
                //params2.put("password", password.getText().toString());
                return params2;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type","application/x-www-form-urlencoded");
                return headers;
            }
        };
        RequestQueueSingleton.getInstance(AddAuctionItemActivity.this).addToRequestQue(request);

        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }

    private void imageBrowse() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if(requestCode == 1){
                Uri picUri = data.getData();

                String filePath = getPath(picUri);

                Log.d("picUri", picUri.toString());
                Log.d("filePath", filePath);

            }

        }

    }

    private void imageUpload(final String imagePath, final String itemID) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        File f  = new File(imagePath);
        String url = "http://10.0.2.2:8080/" + auctionId.toString() + "/" + itemID + "/uploadImage";
        //FileBody fileBody = new FileBody(new File(imagePath)); //image should be a String
        MultipartRequest multipartRequest = null;
        try {
            multipartRequest = new MultipartRequest(Request.Method.POST, url, f, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // parse success output
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("itemId", itemID);
                    return params;
                }

            };
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }

        RequestQueueSingleton.getInstance(AddAuctionItemActivity.this).addToRequestQue(multipartRequest);
    }

    private String getPath(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        CursorLoader loader = new CursorLoader(getApplicationContext(), contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }

    public void uploadImage(View view) {
        imageBrowse();
    }
}
