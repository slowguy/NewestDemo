package com.remote.newestdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class CloseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_close);
        Intent intent = getIntent();
        if (!intent.hasExtra("dd")) {
            Log.e("ddd", "dsa");
        }
//        intent.setDataAndType()

    }
}
