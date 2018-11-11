package com.jmlb0003.randomcoapp.presentation.userlist

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.app.di.PresenterFactory
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.presentation.BaseActivity
import com.jmlb0003.randomcoapp.presentation.details.DetailsActivity

class MainActivity : BaseActivity<MainActivityPresenter.MainActivityView, MainActivityPresenter>(),
                     MainActivityPresenter.MainActivityView,
                     UsersFragment.Callback {

    override fun getPresenter(): MainActivityPresenter = PresenterFactory.createMainActivityPresenter()

    override fun getMVPViewReference(): MainActivityPresenter.MainActivityView = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showLoading() {
        // TODO
        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        // TODO
        Toast.makeText(this, "NOT Loading...", Toast.LENGTH_SHORT).show()
    }

    override fun showUserDetails(user: User) {
        val intent = Intent(this, DetailsActivity::class.java)
        startActivity(intent.putExtras(DetailsActivity.newBundle(user)))
    }

    override fun showError(errorMessage: String) {
        // TODO
        Toast.makeText(this, "Error: $errorMessage", Toast.LENGTH_LONG).show()
    }

    override fun onShowLoading() {
        getPresenter().onShowLoadingFromUsersFragment()
    }

    override fun onHideLoading() {
        getPresenter().onHideLoadingFromUsersFragment()
    }

    override fun onShowError(errorMessage: String) {
        getPresenter().onShowErrorFromUsersFragment(errorMessage)
    }

    override fun onUserClicked(user: User) {
        getPresenter().onUserClicked(user)
    }

}
