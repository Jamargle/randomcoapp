package com.jmlb0003.randomcoapp.presentation.userlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.domain.model.User

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

    fun removeUser(userRemoved: User) {
        val position = usersToShow.indexOf(userRemoved)
        if (position > -1) {
            usersToShow.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun setFavorite(user: User, isFavorite: Boolean) {
        // The flag has been changed in the presenter
        val position = usersToShow.indexOf(user)
        notifyItemChanged(position)
    }

    interface OnUserClickListener {
        fun onUserClicked(user: User)
        fun onDeleteUserClicked(user: User)
        fun onFavoriteClicked(user: User)
    }

}
