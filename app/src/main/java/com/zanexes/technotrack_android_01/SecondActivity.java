package com.zanexes.technotrack_android_01;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.zanexes.technotrack_android_01.adapter.ListViewAdapter;

public class SecondActivity extends Activity {
    private AsyncTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initListView(getApplicationContext());
    }

    private void initListView(Context context) {
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new ListViewAdapter(context));
    }
}
