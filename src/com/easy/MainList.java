package com.easy;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;

public class MainList extends ListActivity {
    // private ListView lv;// 显示类别

    private List<Content> contentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_main);
        initFrame();
    }

    private void initFrame() {// 初始化界面
        getData();
        addListener();
    }

    private void addListener() {// 设置时间监听处理

    }

    private void getData() {// 获取数据,列表\
        contentList = new ArrayList<Content>();
        for (int i = 0; i < 10; i++) {
            Content c = new Content("city");
            contentList.add(c);
        }
        // lv = (ListView) this.findViewById(a);
        // ListAdapter adapter=new SimpleAdapter(this,
        // listmap,android.R.layout.simple_list_item_1, null, null);
        // lv.setAdapter(adapter);
        MyAdapter adapter = new MyAdapter(this, contentList);
        getListView().setAdapter(adapter);

    }

}
