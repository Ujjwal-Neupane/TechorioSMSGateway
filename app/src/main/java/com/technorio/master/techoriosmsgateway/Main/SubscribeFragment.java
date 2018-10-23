package com.technorio.master.techoriosmsgateway.Main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.messaging.FirebaseMessaging;
import com.technorio.master.techoriosmsgateway.R;

/**
 * Created by Ujjwal on 10/23/2018.
 */

public class SubscribeFragment extends Fragment{

    Button subscribe;
    EditText topic;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.subscribe_layout, null);
        subscribe = view.findViewById(R.id.btn_subscribe);
        topic = view.findViewById(R.id.topic);

        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(subscribe.getText().toString().isEmpty()){
                    subscribe.setError("Please enter a topic");
                    subscribe.requestFocus();
                }else{
                    FirebaseMessaging.getInstance().subscribeToTopic(topic.getText().toString());

                }
            }
        });

        return view;
    }
}
