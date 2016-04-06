package com.exercise.jinqiang.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import de.greenrobot.event.EventBus;

/**
 * @author  jinqiang
 */
public class SecondActivity extends AppCompatActivity {
    public SecondActivity(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void onEvent(String event){
        Log.e("second-onEvent", event + "");
    }
    public void onMainThreadEvent(String event){
        Log.e("second", event + "");

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        Log.e("se",  "start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
