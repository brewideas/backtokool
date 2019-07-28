package com.backtokool.infi.backtokool.data.common;

import android.content.Context;
import android.content.SharedPreferences;

public class UserData {
    private static Context mContext;
    public static final String ACCESS_TOKEN = "ACCESS_TOKEN";

    private static String mAccessToken;
    private static boolean mIsDataReady = true;
    public static final String KEY = "com.backtokool.infi.USERDATA_FILE_KEY";

    public static String getAccessToken(){return mAccessToken;}

    //TODO: All Setter must write in Shared preference
    public static void setUserDataReady(boolean isReady){mIsDataReady = isReady;}
    public static void setAccessToken(String token){
        mAccessToken = token;
        writeToSharedPreference (ACCESS_TOKEN, mAccessToken, -1);
    }

    private static void writeToSharedPreference (String key, String value, int int_value){
        SharedPreferences sharedPref = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        if (int_value < 0)
        {
            editor.putString(key, value);
        }
        else {
            editor.putInt(key, int_value);
        }
        editor.commit();
    }


    public static boolean isUserDataReady(){return mIsDataReady;}
    public static boolean isUserAlreadyLoggedIn(){
        SharedPreferences sharedPref = mContext.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        String access_token = sharedPref.getString(ACCESS_TOKEN, null);
        return (access_token != null);
    }
}
