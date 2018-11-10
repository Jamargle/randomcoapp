package com.jmlb0003.randomcoapp.presentation.userlist

import com.jmlb0003.randomcoapp.domain.repository.UsersRepository
import com.jmlb0003.randomcoapp.presentation.BasePresenter
import com.jmlb0003.randomcoapp.presentation.BasePresenterImp

class UsersPresenter(private val repository: UsersRepository) : BasePresenterImp<UsersPresenter.UsersView>() {

    interface UsersView : BasePresenter.BaseView {
    }

}
