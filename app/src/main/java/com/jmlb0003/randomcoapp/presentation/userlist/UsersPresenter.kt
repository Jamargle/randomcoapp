package com.jmlb0003.randomcoapp.presentation.userlist

import com.jmlb0003.randomcoapp.data.UsersSorter
import com.jmlb0003.randomcoapp.domain.TasksSchedulers
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.domain.repository.UsersRepository
import com.jmlb0003.randomcoapp.presentation.BasePresenter
import com.jmlb0003.randomcoapp.presentation.BasePresenterImp
import io.reactivex.disposables.CompositeDisposable

class UsersPresenter(private val repository: UsersRepository,
                     private val schedulers: TasksSchedulers,
                     private val sorter: UsersSorter) : BasePresenterImp<UsersPresenter.UsersView>() {

    private val disposables = CompositeDisposable()
    private val users: MutableList<User> = mutableListOf()

    fun onViewInitialized() {
        getView()?.showLoading()
        disposables.add(repository.getUsers()
            .subscribeOn(schedulers.getBackgroundThread())
            .observeOn(schedulers.getUiThread())
            .subscribe(this::handleSuccessResult, this::handleErrorResult))
    }

    private fun handleSuccessResult(users: List<User>) {
        this.users.addAll(users)
        val sortedUsers = sorter.sortByName(this.users)
        getView()?.let {
            it.hideLoading()
            it.showUsers(sortedUsers)
        }
    }

    private fun handleErrorResult(error: Throwable) {
        getView()?.let {
            it.hideLoading()
            it.showError(error.message ?: "Unknown error")
        }
    }

    fun onDeleteUserClicked(user: User) {
        getView()?.showLoading()
        disposables.add(repository.removeUser(user)
            .subscribeOn(schedulers.getBackgroundThread())
            .observeOn(schedulers.getUiThread())
            .subscribe(this::handleSuccessDeletedResult, this::handleErrorDeleteResult))
    }

    private fun handleSuccessDeletedResult(userRemoved: User) {
        this.users.remove(userRemoved)
        getView()?.let {
            it.hideLoading()
            it.removeUserFromList(userRemoved)
        }
    }

    private fun handleErrorDeleteResult(error: Throwable) {
        getView()?.let {
            it.hideLoading()
            it.showError(error.message ?: "Unknown error")
        }
    }

    fun loadUsers(usersToShow: List<User>?) {
        usersToShow?.let { getView()?.showUsers(it) }
    }

    interface UsersView : BasePresenter.BaseView {

        fun showLoading()

        fun hideLoading()

        fun showUsers(users: List<User>)

        fun removeUserFromList(userRemoved: User)

        fun showError(errorMessage: String)

    }

}
