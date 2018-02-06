package com.remote.newestdemo;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.remote.newestdemo.widget.TouchWebView;

public class Test4Activity extends AppCompatActivity implements View.OnClickListener {

    private View dddd;
    private String str;
    private TouchWebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);
//        dddd = findViewById(R.id.dododo);
//        dddd.setOnClickListener(this);
//        webView = new WebView(this);
//        str = null;
        webview = (TouchWebView) findViewById(R.id.wwwwb);
        initWebView(webview);
        webview.loadUrl("https://s.click.taobao.com/t?e=m%3D2%26s%3DTTHqVNa6VqccQipKwQzePDAVflQIoZeppRe%2F8jaAHci5VBFTL4hn2VfbM99NF9NmJYccVKkURIgHzEuWS5%2BAVHaKqZ%2Bat%2Bo3P8F3Gh%2FXgYXCs1fu0qV3MxGIBQCPmFeJbJBdwKCoumU%3D");

        initEvent();
    }

    private void initEvent() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            webView.setOnScrollChangeListener(scrolling);
//        }
    }

//    private View.OnScrollChangeListener scrolling = new View.OnScrollChangeListener() {
//        @Override
//        public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//
//        }
//    };

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.dododo:
//                ((TextView) v).setText("dsada" + str);
//                break;
//        }
    }

    public void initWebView(WebView paramWebView) {
        WebSettings localWebSettings = paramWebView.getSettings();
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setDefaultTextEncodingName("utf-8");
        paramWebView.getSettings().setBlockNetworkImage(false);//解决图片不显示
//        paramWebView.addJavascriptInterface(new JSInterface(), "jsfl");
        paramWebView.requestFocusFromTouch();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            localWebSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
    }

}
