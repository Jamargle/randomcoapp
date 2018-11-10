package com.jmlb0003.randomcoapp.presentation.userlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.domain.User

class UsersAdapter(private val listener: OnUserClickListener) :
    RecyclerView.Adapter<UserViewHolder>() {

    private val usersToShow: MutableList<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UserViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_user, parent, false))

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(usersToShow[position], listener)
    }

    override fun getItemCount() = usersToShow.size

    fun showUsers(users: List<User>) {
        usersToShow.clear()
        usersToShow.addAll(users)
        notifyDataSetChanged()
    }

    interface OnUserClickListener {
        fun onUserClicked(user: User)
    }

}
