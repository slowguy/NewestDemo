package com.remote.newestdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Test10Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test10)
        test()
    }

    private fun test() {
        object : Thread() {
            override fun run() {
                super.run()
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
        }
    }

    interface OnTestListener {
        fun testSomething()
    }

    private var listener: OnTestListener? = null

    fun setOnTestListener(listener: OnTestListener) {
        this.listener = listener
    }
}
