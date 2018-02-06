package com.remote.newestdemo.widget

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.Switch
import android.widget.TextView
import com.remote.newestdemo.R


class MyTextView : TextView {

    private var mLeft: Int? = 0
    private var mTop: Int? = 0
    private var mRight: Int? = 0
    private var mBottom: Int? = 0
    private var rawX: Int = 0
    private var rawY: Int = 0

    constructor(context: Context) : this(context, null, 0)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setBackgroundColor(Color.parseColor("#ff464e"))
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.e("wLog", "left - $left , right - $right")
        mLeft = left
        mTop = top
        mRight = right
        mBottom = bottom
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val action = event?.action
        when (action) {
            MotionEvent.ACTION_DOWN -> {
                rawX = event.rawX.toInt()
                rawY = event.rawY.toInt()
            }
            MotionEvent.ACTION_MOVE -> {
                val mRawX: Int = event.rawX.toInt()
                val mRawY: Int = event.rawY.toInt()
                val devX: Int = mRawX - rawX
                val devY: Int = mRawY - rawY

                layout(mLeft!! + devX, mTop!! + devY, mRight!! + devX, mBottom!! + devY)
                rawX = mRawX
                rawY = mRawY
            }
            MotionEvent.ACTION_UP -> {

            }
        }
        return true
    }


}