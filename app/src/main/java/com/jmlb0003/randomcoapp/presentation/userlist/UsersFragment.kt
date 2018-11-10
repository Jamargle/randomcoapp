package com.jmlb0003.randomcoapp.presentation.userlist

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.domain.User
import com.jmlb0003.randomcoapp.presentation.userlist.adapter.UsersAdapter

class UsersFragment : Fragment(),
                      UsersAdapter.OnUserClickListener {

    private var callback: Callback? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_users_list, container, false)
        initRecyclerView(view as RecyclerView)
        return view
    }

    private fun initRecyclerView(view: RecyclerView) {
        with(view) {
            adapter = UsersAdapter(listOf(User("pepe", "asdasdas"),
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as? Callback ?: throw RuntimeException(context.toString() + " must implement Callback")
    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }

    override fun onUserClicked(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    interface Callback {
    }

    companion object {

        private const val ARG_COLUMN_COUNT = "column-count"

        fun newInstance() =
            UsersFragment().apply {
                arguments = Bundle()
            }

    }

}
