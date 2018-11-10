package com.jmlb0003.randomcoapp.app.di

import com.jmlb0003.randomcoapp.presentation.userlist.UsersPresenter

object PresenterFactory {

    private val usersPresenterInstance: UsersPresenter by lazy { UsersPresenter(RepositoryFactory.createUsersRepository()) }

    fun createUsersFragmentPresenter(): UsersPresenter = usersPresenterInstance

}
