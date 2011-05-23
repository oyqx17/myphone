package com.easy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class EasyActivity extends Activity {
    private TextView title, content;

    private Button button1, button2, button3;

    // private Button button2, button3;

    private String strjsarray;

    private JSONArray jsa;

    private String titleString;// 标题

    private String contentString;// 内容

    // private HashMap<integer, Object> cmap;// 存储数据对应map

    private MyContent[] my;

    private int mylength;

    private Boolean clicked = false;// 是否点击过

    private int now = 0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initFrame();
        initData();

        /**
         * c初始化数据
         */
        title.setText(my[0].getMytitle());
        content.setText(my[0].getMycontent());
    }

    private void initFrame() {
        title = (TextView) this.findViewById(R.id.title);
        content = (TextView) this.findViewById(R.id.content);
        button1 = (Button) this.findViewById(R.id.button1);
        button2 = (Button) this.findViewById(R.id.button2);
        button3 = (Button) this.findViewById(R.id.button3);

        button1.setOnClickListener(new OnClickListener() {// 顺序

                    public void onClick(View v) {
                        now = now + 1;
                        if (now < mylength) {
                            title.setText(my[now].getMytitle());
                            content.setText(my[now].getMycontent());
                            // title.setText(jsa.getString(index))
                            content.setVisibility(View.GONE);
                            clicked = false;
                        }

                    }
                });
        button2.setOnClickListener(new OnClickListener() {// 隐藏/显示

                    public void onClick(View v) {
                        if (clicked == false) {
                            content.setVisibility(View.VISIBLE);
                            clicked = true;
                        } else {
                            content.setVisibility(View.GONE);
                            clicked = false;
                        }
                        // 
                    }
                });
        button3.setOnClickListener(new OnClickListener() {// 随机

                    public void onClick(View v) {
                        int num = (int) (Math.random() * mylength);
                        now = num;
                        // System.out.println("current num is====>"+num);
                        title.setText(my[num].getMytitle());
                        content.setText(my[num].getMycontent());
                        // title.setText(jsa.getString(index))
                        content.setVisibility(View.GONE);
                        clicked = false;

                    }
                });

    }

    private void initData() {
        // titleString = getResources().getStringArray(R.array.title);
        // contentString = getResources().getStringArray(R.array.content);
        // cmap = new HashMap<integer, Object>();// 存数数据和序列号
        strjsarray = Source.getSource(this);

        try {
            jsa = new JSONArray(strjsarray);
            mylength = jsa.length();
            my = new MyContent[mylength];
            for (int i = 0; i < mylength; i++) {
                String temp = "";
                temp = jsa.get(i).toString();
                // System.out.println(temp);
                int start = temp.indexOf("{") + 2;
                int end = temp.indexOf("\":\"");
                // System.out.println(start+"+"+end);
                String key = jsa.get(i).toString().substring(start, end);
                // System.out.println("key is ---"+key);
                titleString = key;
                contentString = new JSONObject(temp).getString(key);
                // System.out.println("mylength is======>"+mylength);
                my[i] = new MyContent();
                my[i].setMytitle(titleString);
                my[i].setMycontent(contentString);

            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //

    }

    class MyContent {
        public MyContent() {
            super();
        }

        public MyContent(String mytitle, String mycontent) {
            super();
            this.mytitle = mytitle;
            this.mycontent = mycontent;
        }

        private String mytitle;

        public String getMytitle() {
            return mytitle;
        }

        public void setMytitle(String mytitle) {
            this.mytitle = mytitle;
        }

        public String getMycontent() {
            return mycontent;
        }

        public void setMycontent(String mycontent) {
            this.mycontent = mycontent;
        }

        private String mycontent;

    }
}