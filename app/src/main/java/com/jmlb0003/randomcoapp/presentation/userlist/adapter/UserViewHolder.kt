package com.jmlb0003.randomcoapp.presentation.userlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.jmlb0003.randomcoapp.domain.User
import kotlinx.android.synthetic.main.item_list_user.view.user_name
import kotlinx.android.synthetic.main.item_list_user.view.user_surname

class UserViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(user: User, listener: UsersAdapter.OnUserClickListener) {
        view.tag = user
        view.user_name.text = user.name
        view.user_surname.text = user.surname

        view.user_name.setOnClickListener { listener.onUserClicked(view.tag as User) }
    }

}