package com.jmlb0003.randomcoapp.presentation.userlist

import com.jmlb0003.randomcoapp.domain.User
import com.jmlb0003.randomcoapp.presentation.BasePresenter
import com.jmlb0003.randomcoapp.presentation.BasePresenterImp

class MainPresenter : BasePresenterImp<MainPresenter.MainView>() {

    private lateinit var user: User

    fun onCreated() {
        user = User("Pepito", "De los palotes")
        getView()?.showUser(user)
    }

    interface MainView : BasePresenter.BaseView {
        fun showUser(user: User)
    }

}