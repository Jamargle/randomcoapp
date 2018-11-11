package com.jmlb0003.randomcoapp.presentation.details

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.presentation.userlist.MainActivity

class DetailsActivity : AppCompatActivity(), DetailsFragment.Callback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val user = intent.getParcelableExtra<User>(USER_TO_SHOW)
        initToolbar(user.name)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.details_container, DetailsFragment.newInstance(user))
                .commit()
        }
    }

    private fun initToolbar(title: String) = supportActionBar?.let { actionBar ->
        with(actionBar) {
            setDisplayHomeAsUpEnabled(true)
            setTitle(title)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                navigateUpTo(Intent(this, MainActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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

    companion object {
        private const val USER_TO_SHOW = "DetailsActivity:user_to_show"

        fun newBundle(user: User) = Bundle().apply {
            putParcelable(USER_TO_SHOW, user)
        }
    }

}
