package com.technorio.master.techoriosmsgateway.FCM;

import android.telephony.SmsManager;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ujjwal on 10/23/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    String message;
    ArrayList<String> numberList = new ArrayList<>();
    SmsManager smsManager;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        smsManager = SmsManager.getDefault();

        String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();
        String data = remoteMessage.getData().get("body");

        try {
            JSONObject jsonData = new JSONObject(data);
            message = jsonData.getString("message");
            Log.d("messsage", message);

            JSONArray array = jsonData.getJSONArray("numbers");
            for (int i = 0; i < array.length(); i++) {
                numberList.add(array.getString(i));
                Log.d("number_" + i, array.getString(i));
                sendMessage(array.getString(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("sms", "exception occured====================no------");
        }

        MyNotificationManager.getmInstance(getApplicationContext())
                .displayNotification(title, body, message, numberList);
    }

    public void sendMessage(String phoneNo){
        smsManager.sendTextMessage(phoneNo, null, message, null, null);
    }

}
