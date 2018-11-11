package com.jmlb0003.randomcoapp.app.di

import com.jmlb0003.randomcoapp.app.ErrorHandler
import com.jmlb0003.randomcoapp.app.Schedulers
import com.jmlb0003.randomcoapp.data.UsersSorter
import com.jmlb0003.randomcoapp.presentation.details.DetailsPresenter
import com.jmlb0003.randomcoapp.presentation.userlist.MainActivityPresenter
import com.jmlb0003.randomcoapp.presentation.userlist.UsersPresenter

object PresenterFactory {

    private val usersPresenterInstance: UsersPresenter by lazy {
        val repository = RepositoryFactory.createUsersRepository()
        val schedulers = Schedulers
        val sorter = UsersSorter
        UsersPresenter(repository, schedulers, sorter, ErrorHandler)
    }

    private val mainActivityPresenterInstance: MainActivityPresenter by lazy {
        MainActivityPresenter()
    }

    private val userDetailsPresenterInstance: DetailsPresenter by lazy {
        DetailsPresenter(ErrorHandler)
    }

    fun createUsersFragmentPresenter(): UsersPresenter = usersPresenterInstance

    fun createMainActivityPresenter(): MainActivityPresenter = mainActivityPresenterInstance

    fun createUserDetailsPresenter(): DetailsPresenter = userDetailsPresenterInstance

}
