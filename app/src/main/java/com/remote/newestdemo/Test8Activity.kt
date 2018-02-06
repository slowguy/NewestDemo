package com.remote.newestdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Test8Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test8)
    }

    internal inner class MyThread : Thread() {
        override fun run() {
            super.run()
            getSomething()
        }
    }

    fun getSomething() {

    }
}
