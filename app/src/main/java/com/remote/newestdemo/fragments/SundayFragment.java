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

public class SundayFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("fragmentLift", "sunday-onCreateView");
        return inflater.inflate(R.layout.fragment_sunday, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("fragmentLift", "sunday-onCreate");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("fragmentLift", "sunday-onViewCreated");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("fragmentLift", "sunday-onAttach");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("fragmentLift", "sunday-onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("fragmentLift", "sunday-onResume");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e("fragmentLift", "sunday-onHiddenChanged " + hidden);
    }
}
