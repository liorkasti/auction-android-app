package com.example.user.art_auction;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by USER on 25/11/2017.
 */

public class UserSessionSingleton {
    private static final String MY_PREFERENCE = "MyPreference";
    private static final String IS_LOGGED_IN = "isLoggedIn";
    private static final String USER_ID = "userId";
    private static UserSessionSingleton myInstance = null;
    private SharedPreferences.Editor _editor;
    private SharedPreferences _pref;

    private UserSessionSingleton(Context ctx){
        _pref = ctx.getSharedPreferences(MY_PREFERENCE, 0); // 0 - for private mode
        _editor = _pref.edit();
    }

    public static UserSessionSingleton getInstance(Context ctx){
        if(myInstance == null){
            myInstance = new UserSessionSingleton(ctx);
        }
        return myInstance;
    }

    public void loginUser(String userId){
        _editor.putBoolean(IS_LOGGED_IN, true);
        _editor.putString(USER_ID, userId);
        _editor.commit();
    }

    public String getSessionId(){
        if(isLoggedIn()){
            return _pref.getString(USER_ID, null);
        }
        return null;
    }

    public void logoutUser(){
        _editor.clear();
        _editor.commit();
    }

    public boolean isLoggedIn(){
        return _pref.getBoolean(IS_LOGGED_IN, false);
    }
}
