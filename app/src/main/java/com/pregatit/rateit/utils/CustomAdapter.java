package com.pregatit.rateit.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.pregatit.rateit.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<AdapterRowItem> {
    LayoutInflater inflater;

    public CustomAdapter(@NonNull Context context, int resource, List<AdapterRowItem> list) {
        super(context, resource, list);
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        AdapterRowItem item = getItem(position);
        TextView tv = new TextView(this.getContext());
        tv.setText(item.getName());
        convertView = tv;
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        convertView = inflater.inflate(R.layout.category_spinner,null);
        AdapterRowItem item = getItem(position);
        TextView tv = (TextView) convertView.findViewById(R.id.categoryTextView);
        tv.setText(item.getName());
        return convertView;
    }
}
