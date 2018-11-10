package com.jmlb0003.randomcoapp.presentation.userlist

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.domain.User
import com.jmlb0003.randomcoapp.presentation.BaseFragment
import com.jmlb0003.randomcoapp.presentation.userlist.adapter.UsersAdapter

class UsersFragment : BaseFragment<UsersFragment.Callback, UsersPresenter.UsersView, UsersPresenter>(),
                      UsersPresenter.UsersView,
                      UsersAdapter.OnUserClickListener {

    private val presenterInstance: UsersPresenter by lazy { UsersPresenter() }

    override val layoutResourceId: Int
        get() = R.layout.fragment_users_list

    override fun getPresenter() = presenterInstance

    override fun getMVPViewReference(): UsersPresenter.UsersView = this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view as RecyclerView)
    }

    private fun initRecyclerView(view: RecyclerView) {
        with(view) {
            adapter = UsersAdapter(mutableListOf(User("pepe", "asdasdas"),
                    User("pepe", "asdasdas"),
                    User("pepe", "asdasdas"),
                    User("pepe", "asdasdas"),
                    User("pepe", "asdasdas"),
                    User("pepe", "asdasdas"),
                    User("pepe", "asdasdas"),
                    User("pepe", "asdasdas")),
                    this@UsersFragment)
        }
    }

    override fun onUserClicked(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    interface Callback {
    }

    companion object {

        fun newInstance() =
            UsersFragment().apply {
                arguments = Bundle()
            }

    }

}
