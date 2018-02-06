package com.remote.newestdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Test3Activity extends AppCompatActivity {

    private String scheme = "newest://cc_temp.com/what?name=wsl";
//    private String scheme = "weixin://dl/profile";
//    private String scheme = "jwrebate://inner/incomedetails?tabindex=2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
        findViewById(R.id.aaaa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scheme));
//                intent.putExtra("time", "2014");
                startActivity(intent);
            }
        });
        findViewById(R.id.bbbb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scheme));
//                Intent intent = new Intent(Test3Activity.this, CloseActivity.class);
//                intent.putExtra("time", "2014");
//                startActivity(intent);
//                registerReceiver()
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
