package com.jmlb0003.randomcoapp.presentation.userlist

import com.jmlb0003.randomcoapp.app.ErrorHandler
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.presentation.BasePresenter
import com.jmlb0003.randomcoapp.presentation.BasePresenterImp

class MainActivityPresenter : BasePresenterImp<MainActivityPresenter.MainActivityView>() {

    override fun getErrorHandler(): ErrorHandler? = null

    fun onCreated(isTablet: Boolean) {
        if (isTablet) {
            getView()?.showFavoritesScreen()
        }
    }

    fun onShowLoadingFromUsersFragment() {
        getView()?.showLoading()
    }

    fun onHideLoadingFromUsersFragment() {
        getView()?.hideLoading()
    }

    fun onShowErrorFromUsersFragment(errorMessage: String) {
        getView()?.showError(errorMessage)
    }

    fun onUserClicked(user: User) {
        getView()?.showUserDetails(user)
    }

    fun onLoadMoreUsers() {
        getView()?.loadMoreUsers()
    }

    fun onShowFavoriteCharacters() {
        getView()?.showOnlyFavorites()
    }

    fun onShowEveryUser() {
        getView()?.showEveryUser()
    }

    interface MainActivityView : BasePresenter.BaseView {

        fun showLoading()

        fun hideLoading()

        fun showUserDetails(user: User)

        fun showFavoritesScreen()

        fun loadMoreUsers()

        fun showOnlyFavorites()

        fun showEveryUser()

        fun showError(errorMessage: String)

    }

}
