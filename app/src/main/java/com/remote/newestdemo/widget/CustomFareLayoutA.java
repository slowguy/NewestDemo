package com.remote.newestdemo.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.remote.newestdemo.R;


/**
 * Created by wsl on 2017/8/25.
 */

public class CustomFareLayoutA extends LinearLayout {


    private TextView fareNum;
    private TextView fareTips;

    public CustomFareLayoutA(Context context) {
        this(context, null);
    }

    public CustomFareLayoutA(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomFareLayoutA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_fare_item, this, true);
        initView(view);
    }

    private void initView(View view) {
        fareNum = (TextView) view.findViewById(R.id.fare_num);
        fareTips = (TextView) view.findViewById(R.id.fare_tips);
    }

    public void setBg(@DrawableRes int res) {
        fareNum.setBackgroundResource(res);
    }

    public void setFareNum(CharSequence num) {
        fareNum.setText(num);
    }

    public void setFareTips(String tips) {
        fareTips.setText(tips);
    }
}
