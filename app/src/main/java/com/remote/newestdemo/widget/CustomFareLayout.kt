package com.remote.newestdemo.widget

import android.content.Context
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

import com.remote.newestdemo.R


/**
 * Created by wsl on 2017/8/25.
 */

class CustomFareLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {


    private var fareNum: TextView? = null
    private var fareTips: TextView? = null

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_fare_item, this, true)
        initView(view)
    }

    private fun initView(view: View) {
        fareNum = view.findViewById(R.id.fare_num) as TextView
        fareTips = view.findViewById(R.id.fare_tips) as TextView
    }

    fun setBg(@DrawableRes res: Int) {
        fareNum!!.setBackgroundResource(res)
    }

    fun setFareNum(num: CharSequence) {
        fareNum!!.text = num
    }

    fun setFareTips(tips: String) {
        fareTips!!.text = tips
    }
}
