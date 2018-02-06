package com.remote.newestdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.remote.newestdemo.widget.MyTextView
import com.remote.newestdemo.widget.TestTextView
import org.w3c.dom.Text
import javax.xml.datatype.Duration

class MainActivity : AppCompatActivity(), View.OnClickListener {

//    private val center: TestTextView by lazy { findViewById(R.id.center_text) as TestTextView }

    private val action: TextView by lazy { findViewById(R.id.action) as TextView }

    private val str: String = "time"

    private var arr1 = intArrayOf(1, 2, 2)
    private var arr2 = arrayOf("1", 2, "4", true)
    private var arr3 = booleanArrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initEvent()
    }

    private fun initView() {
    }

    private fun initEvent() {
        action.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.action -> {
                str.let {
//                    Log.e("timer", "content - $it")
//                    val len = testLet()
//                    Log.e("resuuuult", "len -> $len")
//                    val str = testApply()
//                    Log.e("wzzzl", "apply = $str")
                    testFor()
                }
            }
        }
    }

    fun testLet(): Int {
        return "mytest".let {
            Log.e("logTag", "msg")
            it.length
        }
    }

    fun testApply(): String {
        return "applytest".apply {
//            val sb: StringBuilder
//            val sb = StringBuilder(this)
//            sb.append("-")
//            sb.append(">")
//            sb.append("!")

        }
    }

    fun testFun() {
        var intent = Intent(this, CloseActivity::class.java)
        intent.putExtra("tag", "1")
    }

    fun testFor() {
        for (item in 0 until 10) {
            Log.e("lololol", "item->$item")
        }
    }



}
