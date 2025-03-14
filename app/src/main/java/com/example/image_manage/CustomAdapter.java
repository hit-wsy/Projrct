package com.example.image_manage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List<String> items;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, List<String> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size() + 1; // Including "新建用户"
    }

    @Override
    public Object getItem(int position) {
        return position < items.size() ? items.get(position) : "新建用户";
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView != null ? convertView : inflater.inflate(R.layout.menu_item_layout, parent, false);
        TextView textView = view.findViewById(R.id.menu_item_text);
        ImageView imageView = view.findViewById(R.id.menu_item_icon);

        textView.setText((String) getItem(position));
        if (position < items.size()) {
            imageView.setImageResource(R.drawable.user); // Set your icon for user items
        } else {
            imageView.setImageResource(R.drawable.add); // Set your icon for "新建用户"
        }
        return view;
    }
}
