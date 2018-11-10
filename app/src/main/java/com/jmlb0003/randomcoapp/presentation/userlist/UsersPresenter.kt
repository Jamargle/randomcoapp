package com.jmlb0003.randomcoapp.presentation.userlist

import com.jmlb0003.randomcoapp.domain.User
import com.jmlb0003.randomcoapp.domain.repository.UsersRepository
import com.jmlb0003.randomcoapp.presentation.BasePresenter
import com.jmlb0003.randomcoapp.presentation.BasePresenterImp

class UsersPresenter(private val repository: UsersRepository) : BasePresenterImp<UsersPresenter.UsersView>() {

    fun onViewInitialized() {
        val users = repository.getUsers()
        getView()?.showUsers(users)
    }

    interface UsersView : BasePresenter.BaseView {

        fun showUsers(users: List<User>)

    }

}
