package com.remote.newestdemo

import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.media.MediaPlayer
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.NotificationCompat
import android.view.View
import android.widget.RemoteViews

import com.remote.newestdemo.widget.RoundLinearLayout

class TestActivity : AppCompatActivity(), View.OnClickListener {

    private var rll: RoundLinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        rll = findViewById(R.id.rll) as RoundLinearLayout
        rll!!.setBackgroundColor(Color.parseColor("#f24439"))
        rll!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.rll -> {
                val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val builder = NotificationCompat.Builder(this)
                builder.setContentTitle("title")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentText("content")
                        .setSound(Uri.parse("android.resource://$packageName/${R.raw.shake}"))
                        .setAutoCancel(true)
                nm.notify(1, builder.build())
            }
        }
    }
}
