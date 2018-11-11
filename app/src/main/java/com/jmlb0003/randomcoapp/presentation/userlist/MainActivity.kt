package com.jmlb0003.randomcoapp.presentation.userlist

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.app.di.PresenterFactory
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.presentation.BaseActivity
import com.jmlb0003.randomcoapp.presentation.details.DetailsActivity
import com.jmlb0003.randomcoapp.presentation.favorites.FavoritesFragment

class MainActivity : BaseActivity<MainActivityPresenter.MainActivityView, MainActivityPresenter>(),
                     MainActivityPresenter.MainActivityView,
                     UsersFragment.Callback {

    override fun getPresenter(): MainActivityPresenter = PresenterFactory.createMainActivityPresenter()

    override fun getMVPViewReference(): MainActivityPresenter.MainActivityView = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPresenter().onCreated(resources.getBoolean(R.bool.isTablet))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_user_list, menu)
        initSearchViewQueryTextListener((menu?.findItem(R.id.action_search)?.actionView as SearchView))
        return super.onCreateOptionsMenu(menu)
    }

    private fun initSearchViewQueryTextListener(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // TODO Query logic that should be handled by the fragment via a public method
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // TODO Query logic that should be handled by the fragment via a public method
                return false
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?) =
        when (item?.itemId) {
            R.id.action_load_more_users -> {
                getPresenter().onLoadMoreUsers()
                true
            }
            R.id.action_show_favorites -> {
                getPresenter().onShowFavoriteCharacters()
                true
            }
            R.id.action_show_everyone -> {
                getPresenter().onShowEveryUser()
                true
            }
            else -> super.onOptionsItemSelected(item)
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

    override fun showFavoritesScreen() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.user_favorites, FavoritesFragment.newInstance())
            .commit()
    }

    override fun loadMoreUsers() {
        (supportFragmentManager.findFragmentById(R.id.user_list_fragment) as? UsersFragment)?.loadMoreUsers()
    }

    override fun showOnlyFavorites() {
        (supportFragmentManager.findFragmentById(R.id.user_list_fragment) as? UsersFragment)?.showOnlyFavoriteUsers()
    }

    override fun showEveryUser() {
        (supportFragmentManager.findFragmentById(R.id.user_list_fragment) as? UsersFragment)?.showEveryUser()
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
