package com.remote.newestdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View

class Test9Activity : AppCompatActivity(), View.OnTouchListener {

    private var downX = 0
    private var downY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test9)
        val v = View(this)
        v.setOnTouchListener(this)
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        var moveX = 0
        var moveY = 0
        var devX = 0
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.rawX.toInt()
                downY = event.rawY.toInt()
            }
            MotionEvent.ACTION_MOVE -> {
                moveX = event.rawX.toInt()
                moveY = event.rawY.toInt()
                devX = moveX - downX
            }
        }
        return false
    }
}
