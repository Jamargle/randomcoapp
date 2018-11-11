package com.jmlb0003.randomcoapp.app.di

import com.jmlb0003.randomcoapp.app.ErrorHandler
import com.jmlb0003.randomcoapp.app.Schedulers
import com.jmlb0003.randomcoapp.data.UsersSorter
import com.jmlb0003.randomcoapp.presentation.userlist.MainActivityPresenter
import com.jmlb0003.randomcoapp.presentation.userlist.UsersPresenter

object PresenterFactory {

    private val usersPresenterInstance: UsersPresenter by lazy {
        val repository = RepositoryFactory.createUsersRepository()
        val schedulers = Schedulers
        val sorter = UsersSorter
        val errorHandler = ErrorHandler
        UsersPresenter(repository, schedulers, sorter, errorHandler)
    }

    private val mainActivityPresenterInstance: MainActivityPresenter by lazy {
        MainActivityPresenter()
    }

    fun createUsersFragmentPresenter(): UsersPresenter = usersPresenterInstance

    fun createMainActivityPresenter(): MainActivityPresenter = mainActivityPresenterInstance

}
