package com.jmlb0003.randomcoapp.presentation.userlist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.domain.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testUser = User("Pepito", "De los palotes")
        textView.text = "${testUser.name} ${testUser.surname}"
    }
}
