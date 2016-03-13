package com.zanexes.technotrack_android_01;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import com.zanexes.technotrack_android_01.adapter.ListViewAdapter;

public class SecondActivity extends AppCompatActivity {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
