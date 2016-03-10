package com.zanexes.technotrack_android_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class FirstActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        introActivity();
    }

    private void introActivity() {
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
