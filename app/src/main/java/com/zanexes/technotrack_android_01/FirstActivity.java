package com.zanexes.technotrack_android_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class FirstActivity extends Activity {

    private Handler handler;
    private Runnable introActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        introActivity();
    }

    private void introActivity() {
//        handler = new Handler();
//
//        introActivity = new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        };
//
//        handler.postDelayed(introActivity, 2000);
        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    int logoTimer = 0;
                    while(logoTimer < 2000) {
                        sleep(100);
                        logoTimer = logoTimer +100;
                    };
                    Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    finish();
                }
            }
        };
        timer.start();
    }
}
