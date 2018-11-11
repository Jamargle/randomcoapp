package com.jmlb0003.randomcoapp.presentation.userlist

import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.presentation.BasePresenter
import com.jmlb0003.randomcoapp.presentation.BasePresenterImp

class MainActivityPresenter : BasePresenterImp<MainActivityPresenter.MainActivityView>() {

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

    interface MainActivityView : BasePresenter.BaseView {

        fun showLoading()

        fun hideLoading()

        fun showUserDetails(user: User)

        fun showError(errorMessage: String)

    }

}
