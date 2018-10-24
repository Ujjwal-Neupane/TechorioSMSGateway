package com.technorio.master.techoriosmsgateway.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by Ujjwal on 10/23/2018.
 */

public class SharedPrefManager {

    private static Context mCtx;
    private static SharedPrefManager mInstance;
    private static final String KEY_USER_STATUS= "userStatus";
    private static final String KEY_SUBSC_TOPIC= "subscriptionTopic";

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public void storeTitle(String title){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.KEY_TITLE, title);
        editor.apply();
    }

    public String getTitle(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Constants.KEY_TITLE, null);
    }

    public void setUserStatus(Boolean userStatus){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_USER_STATUS, userStatus);
        editor.apply();
    }

    public Boolean getUserStatus(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(KEY_USER_STATUS, false);
    }

    public void setSubscriptionTopic(String topic){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_SUBSC_TOPIC, topic);
        editor.apply();
    }

    public String getSubsctiptionTopic(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_SUBSC_TOPIC, "");

    }

}
