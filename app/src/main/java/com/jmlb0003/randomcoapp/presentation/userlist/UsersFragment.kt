package com.jmlb0003.randomcoapp.presentation.userlist

import android.os.Bundle
import android.view.View
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.app.di.PresenterFactory
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.presentation.BaseFragment
import com.jmlb0003.randomcoapp.presentation.userlist.adapter.UsersAdapter
import kotlinx.android.synthetic.main.fragment_users_list.view.user_list_view

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

        presenterInstance.onViewInitialized()
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

    override fun showError(errorMessage: String) {
        adapter.showUsers(emptyList())
        callback?.onShowError(errorMessage)
    }

    override fun onUserClicked(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    interface Callback {

        fun onShowLoading()

        fun onHideLoading()

        fun onShowError(errorMessage: String)

    }

    companion object {

        fun newInstance() =
            UsersFragment().apply {
                arguments = Bundle()
            }

    }

}
