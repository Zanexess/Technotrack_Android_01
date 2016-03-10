package com.zanexes.technotrack_android_01;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.zanexes.technotrack_android_01.adapter.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SecondActivity extends Activity {
    private AsyncTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        asyncTask = new DataAsyncTask().execute();
        try {
            initListView(getApplicationContext());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initListView(Context context) throws ExecutionException, InterruptedException {
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new ListViewAdapter(context, (List<String>) asyncTask.get()));
    }

    private List<String> getMock() {
        //TODO AsyncTask
        List<String> data = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {
            data.add(i+"");
        }
        return data;
    }
}
