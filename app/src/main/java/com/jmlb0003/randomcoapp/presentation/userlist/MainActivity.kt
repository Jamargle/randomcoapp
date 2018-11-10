package com.jmlb0003.randomcoapp.presentation.userlist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jmlb0003.randomcoapp.R

class MainActivity : AppCompatActivity(), UsersFragment.Callback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
