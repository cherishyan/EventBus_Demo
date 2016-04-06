package com.exercise.jinqiang.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import de.greenrobot.event.EventBus;

/**
 * @author  jinqiang
 */
public class ThirdActivity extends AppCompatActivity{
    public ThirdActivity(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void onEvent(String event){
        Log.e("third-onEvent", event + "");
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        Log.e("third",  "start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
