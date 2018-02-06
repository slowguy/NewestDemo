package com.remote.newestdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class OpenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        Intent intent = getIntent();
        if (intent.hasExtra("time")) {
            Toast.makeText(this, intent.getStringExtra("time"), Toast.LENGTH_SHORT).show();
        }
    }
}
