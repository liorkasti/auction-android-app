package com.example.user.art_auction;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by USER on 25/11/2017.
 */

public class RequestQueueSingleton {
    private RequestQueue requestQueue;
    private static Context mctx;

    private RequestQueueSingleton(Context context){
        this.mctx=context;
        this.requestQueue=getRequestQueue();

    }
    public RequestQueue getRequestQueue(){
        if (requestQueue==null){
            requestQueue= Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized RequestQueueSingleton getInstance(Context context){
        if (ourInstance==null){
            ourInstance=new RequestQueueSingleton(context);
        }
        return ourInstance;
    }
    public<T> void addToRequestQue(Request<T> request){
        requestQueue.add(request);

    }

    private static RequestQueueSingleton ourInstance;
}
