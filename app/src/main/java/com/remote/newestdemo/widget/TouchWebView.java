package com.remote.newestdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * Created by wsl on 2017/11/24.
 */

public class TouchWebView extends WebView {

    public TouchWebView(Context context) {
        super(context);
    }

    public TouchWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent evt) {

        switch (evt.getAction()) {

            case MotionEvent.ACTION_DOWN:
                Log.e("asdasda", "down");
                //do something......
                break;

            case MotionEvent.ACTION_MOVE:
                Log.e("asdasda", "move");

                //do something......
                break;
            case MotionEvent.ACTION_UP:
                //do something......
                Log.e("asdasda", "up");

                break;
        }
        return false;
    }
}
