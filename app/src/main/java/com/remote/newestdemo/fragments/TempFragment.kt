package com.remote.newestdemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by wsl on 2018/1/5.
 */

class TempFragment : MondayFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object {

        val instance: TempFragment
            get() {
                val fragment = TempFragment()
                val bundle = Bundle()
                bundle.putString("12", "123")
                fragment.arguments = bundle
                return fragment
            }
    }
}
