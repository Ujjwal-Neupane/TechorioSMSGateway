package com.technorio.master.techoriosmsgateway.Main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorio.master.techoriosmsgateway.R;

/**
 * Created by Ujjwal on 10/23/2018.
 */

public class MessageHistoryFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.message_history, null);
        return view;
    }
}
