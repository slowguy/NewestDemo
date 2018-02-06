package com.remote.newestdemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.remote.newestdemo.fragments.MondayFragment;
import com.remote.newestdemo.fragments.SundayFragment;

public class FragActivity extends AppCompatActivity {

    private FragmentTransaction transaction;
    private MondayFragment mondayFragment;
    private FrameLayout fragParent;
    private SundayFragment sundayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
        init();
    }

    private void init() {
//        fragParent = (FrameLayout) findViewById(R.id.frag_parent);
        transaction = getSupportFragmentManager().beginTransaction();
        if (mondayFragment == null) {
            mondayFragment = new MondayFragment();
            transaction.add(R.id.frag_parent, mondayFragment);
        }
        if (sundayFragment == null) {
            sundayFragment = new SundayFragment();
            transaction.add(R.id.frag_parent, sundayFragment);
        }
        transaction.show(mondayFragment);
        transaction.commit();
    }

    public void mondayClick(View v) {
        transaction = getSupportFragmentManager().beginTransaction();
        Log.e("aass", "1111");
        transaction.hide(sundayFragment);
        transaction.show(mondayFragment);
        transaction.commit();
    }

    public void sundayClick(View v) {
        transaction = getSupportFragmentManager().beginTransaction();
        Log.e("aass", "2222");
        transaction.hide(mondayFragment);
        transaction.show(sundayFragment);
        transaction.commit();
    }
}
