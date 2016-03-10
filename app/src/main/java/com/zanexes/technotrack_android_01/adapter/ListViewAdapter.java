package com.zanexes.technotrack_android_01.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zanexes.technotrack_android_01.NumericParser;
import com.zanexes.technotrack_android_01.R;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    private static final int COUNT = 1000000 - 1;

    public ListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public Object getItem(int position) {
        return NumericParser.digits2text(position + 1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String str = (String) getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.textView.setText(str);
        if ((position & 1) == 1) {
            convertView.setBackgroundColor(Color.GRAY);
        } else {
            convertView.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }

    public static class ViewHolder {
        TextView textView;
        public ViewHolder(View view) {
            this.textView = (TextView) view.findViewById(R.id.item_textView);
        }
    }
}
