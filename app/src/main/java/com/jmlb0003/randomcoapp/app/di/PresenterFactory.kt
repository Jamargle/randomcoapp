package com.jmlb0003.randomcoapp.app.di

import com.jmlb0003.randomcoapp.app.Schedulers
import com.jmlb0003.randomcoapp.presentation.userlist.UsersPresenter

object PresenterFactory {

    private val usersPresenterInstance: UsersPresenter by lazy {
        val repository = RepositoryFactory.createUsersRepository()
        val schedulers = Schedulers
        UsersPresenter(repository, schedulers)
    }

    fun createUsersFragmentPresenter(): UsersPresenter = usersPresenterInstance

}
