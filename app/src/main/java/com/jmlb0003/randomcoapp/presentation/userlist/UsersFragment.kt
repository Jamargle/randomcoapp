package com.jmlb0003.randomcoapp.presentation.userlist

import android.os.Bundle
import android.view.View
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.app.di.PresenterFactory
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.presentation.BaseFragment
import com.jmlb0003.randomcoapp.presentation.userlist.adapter.UsersAdapter
import kotlinx.android.synthetic.main.fragment_users_list.view.user_list_view
import java.util.ArrayList

private const val SAVED_LIST_OF_USERS = "UsersFragment:users"

class UsersFragment : BaseFragment<UsersFragment.Callback, UsersPresenter.UsersView, UsersPresenter>(),
                      UsersPresenter.UsersView,
                      UsersAdapter.OnUserClickListener {

    private val presenterInstance: UsersPresenter by lazy { PresenterFactory.createUsersFragmentPresenter() }
    private lateinit var adapter: UsersAdapter

    override val layoutResourceId: Int
        get() = R.layout.fragment_users_list

    override fun getPresenter() = presenterInstance

    override fun getMVPViewReference(): UsersPresenter.UsersView = this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = UsersAdapter(this@UsersFragment)
        view.user_list_view.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (hasNetworkConnection()) {
            if (savedInstanceState != null) {
                recoverState(savedInstanceState)
            } else {
                presenterInstance.onViewInitialized()
            }
        } else {
            presenterInstance.onNoNetworkConnection()
        }
    }

    private fun recoverState(state: Bundle) {
        if (state.containsKey(SAVED_LIST_OF_USERS)) {
            presenterInstance.loadUsers(state.getParcelableArrayList(SAVED_LIST_OF_USERS))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val users: java.util.ArrayList<User> = adapter.getUsers() as ArrayList<User>
        outState.putParcelableArrayList(SAVED_LIST_OF_USERS, users)
        super.onSaveInstanceState(outState)
    }

    fun loadMoreUsers() {
        presenterInstance.onLoadMoreUsers()
    }

    fun showOnlyFavoriteUsers() {
        presenterInstance.onShowOnlyFavoriteUsers()
    }

    fun showEveryUser() {
        presenterInstance.onShowUsersWithoutFilter()
    }

    override fun showLoading() {
        callback?.onShowLoading()
    }

    override fun hideLoading() {
        callback?.onHideLoading()
    }

    override fun showUsers(users: List<User>) {
        adapter.showUsers(users)
    }

    override fun removeUserFromList(userRemoved: User) {
        adapter.removeUser(userRemoved)
    }

    override fun swapToFavorite(user: User) {
        adapter.setFavorite(user)
    }

    override fun swapToNoFavorite(user: User) {
        adapter.setFavorite(user)
    }

    override fun showError(errorMessage: String) {
        adapter.showUsers(emptyList())
        callback?.onShowError(errorMessage)
    }

    override fun onUserClicked(user: User) {
        callback?.onUserClicked(user)
    }

    override fun onDeleteUserClicked(user: User) {
        presenterInstance.onDeleteUserClicked(user)
    }

    override fun onFavoriteClicked(user: User) {
        presenterInstance.onFavoriteClicked(user)
    }

    interface Callback {

        fun onShowLoading()

        fun onHideLoading()

        fun onShowError(errorMessage: String)

        fun onUserClicked(user: User)

    }

    companion object {

        fun newInstance() =
            UsersFragment().apply {
                arguments = Bundle()
            }

    }

}
