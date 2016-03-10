package com.zanexes.technotrack_android_01;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

public class DataAsyncTask extends AsyncTask<Void, List<String>, List<String>> {

    @Override
    protected List<String> doInBackground(Void... params) {
        List<String> data = new ArrayList<>();
        for (int i = 1; i < 1000000; i++) {
            data.add(i+"");
        }
        return data;
    }

    @Override
    protected void onPostExecute(List<String> list) {
        super.onPostExecute(list);
    }
}
