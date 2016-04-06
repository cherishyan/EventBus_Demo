package com.exercise.jinqiang.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import de.greenrobot.event.EventBus;


public class MainActivity extends AppCompatActivity {

    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //要不同组件之间发送event,需要注册要发送的那个组件,要发送多个则注册多个
        EventBus eventBus = new EventBus();
        SecondActivity secondActivity = new SecondActivity();
        ThirdActivity thirdActivity = new ThirdActivity();
        eventBus.register(secondActivity);
        eventBus.register(thirdActivity);

        eventBus.post("456");
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void onEvent(String event){
        Log.e("Main",event+"123");
    }


    @Override
    protected void onStart() {
        super.onStart();
        //注册EventBus，内部发送只需getDefault()，再复写onEvent ( 非override )
//        EventBus.getDefault().register(this);
    }


    @Override
    protected void onStop() {
        super.onStop();
        //取消EventBus
        EventBus.getDefault().unregister(this);
    }




}
