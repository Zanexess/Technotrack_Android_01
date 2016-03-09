package com.zanexes.technotrack_android_01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.zanexes.technotrack_android_01.adapter.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initListView(getApplicationContext());
    }

    private void initListView(Context context) {
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new ListViewAdapter(context, getMock()));
    }


    private List<String> getMock() {
        //TODO AsyncTask
        List<String> data = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            data.add(i+"");
        }
        return data;
    }
}
