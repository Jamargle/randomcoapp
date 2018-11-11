package com.jmlb0003.randomcoapp.presentation.userlist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.jmlb0003.randomcoapp.R

class MainActivity : AppCompatActivity(), UsersFragment.Callback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onShowLoading() {
        // TODO
        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
    }

    override fun onHideLoading() {
        // TODO
        Toast.makeText(this, "NOT Loading...", Toast.LENGTH_SHORT).show()
    }

    override fun onShowError(errorMessage: String) {
        // TODO
        Toast.makeText(this, "Error: $errorMessage", Toast.LENGTH_LONG).show()
    }

}
