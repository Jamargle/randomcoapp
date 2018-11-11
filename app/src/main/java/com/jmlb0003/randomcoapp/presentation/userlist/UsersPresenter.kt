package com.jmlb0003.randomcoapp.presentation.userlist

import com.jmlb0003.randomcoapp.domain.TasksSchedulers
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.domain.repository.UsersRepository
import com.jmlb0003.randomcoapp.presentation.BasePresenter
import com.jmlb0003.randomcoapp.presentation.BasePresenterImp
import io.reactivex.disposables.CompositeDisposable

class UsersPresenter(private val repository: UsersRepository,
                     private val schedulers: TasksSchedulers) : BasePresenterImp<UsersPresenter.UsersView>() {

    private val disposables = CompositeDisposable()

    fun onViewInitialized() {
        getView()?.showLoading()
        disposables.add(repository.getUsers()
            .subscribeOn(schedulers.getBackgroundThread())
            .observeOn(schedulers.getUiThread())
            .subscribe(this::handleSuccessResult, this::handleErrorResult))
    }

    private fun handleSuccessResult(users: List<User>) {
        val sortedUsers = sortUsersByName(users)
        getView()?.let {
            it.hideLoading()
            it.showUsers(sortedUsers)
        }
    }

    private fun sortUsersByName(users: List<User>): List<User> {
        return users.sortedBy { it.name }
    }

    private fun handleErrorResult(error: Throwable) {
        getView()?.let {
            it.hideLoading()
            it.showError(error.message ?: "Unknown error")
        }
    }

    private fun displayLoading() {
        // TODO
    }

    private fun hideLoading() {
        // TODO
    }

    interface UsersView : BasePresenter.BaseView {

        fun showLoading()

        fun hideLoading()

        fun showUsers(users: List<User>)

        fun showError(errorMessage: String)

    }

}
