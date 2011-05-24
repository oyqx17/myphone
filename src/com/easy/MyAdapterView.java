package com.easy;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapterView extends LinearLayout {

    public MyAdapterView(Context context, Content content) {
        super(context);
        this.setOrientation(HORIZONTAL);
        LinearLayout.LayoutParams contentParams = new LinearLayout.LayoutParams(
                100, LayoutParams.WRAP_CONTENT);
        contentParams.setMargins(1, 1, 1, 1);
        TextView contentText = new TextView(context);
        contentText.setText(content.getCity());
        addView(contentText, contentParams);

    }
}
