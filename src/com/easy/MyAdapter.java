package com.easy;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MyAdapter extends BaseAdapter {
    private Context context;

    private List<Content> contentList;

    public MyAdapter(Context context, List<Content> contentList) {
        this.context = context;
        this.contentList = contentList;

    }

    @Override
    public int getCount() {
        return contentList.size();
    }

    @Override
    public Object getItem(int position) {
        return contentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Content content = contentList.get(position);
        return new MyAdapterView(this.context, content);
    }

}
