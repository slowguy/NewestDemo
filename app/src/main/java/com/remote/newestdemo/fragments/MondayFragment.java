package com.remote.newestdemo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.remote.newestdemo.R;

/**
 * Created by wsl on 2017/10/24.
 */

public class MondayFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("fragmentLift", "monday-onCreateView");
        return inflater.inflate(R.layout.fragment_monday, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("fragmentLift", "monday-onCreate");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("fragmentLift", "monday-onViewCreated");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("fragmentLift", "monday-onAttach");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("fragmentLift", "monday-onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("fragmentLift", "monday-onResume");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e("fragmentLift", "monday-onHiddenChanged " + hidden);
    }
}
