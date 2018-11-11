package com.jmlb0003.randomcoapp.presentation.userlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.jmlb0003.randomcoapp.domain.model.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_user.view.delete_user
import kotlinx.android.synthetic.main.item_list_user.view.favorite_button
import kotlinx.android.synthetic.main.item_list_user.view.user_email
import kotlinx.android.synthetic.main.item_list_user.view.user_name
import kotlinx.android.synthetic.main.item_list_user.view.user_phone
import kotlinx.android.synthetic.main.item_list_user.view.user_picture
import kotlinx.android.synthetic.main.item_list_user.view.user_surname

class UserViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(user: User, listener: UsersAdapter.OnUserClickListener) {
        view.tag = user

        Picasso.with(view.context).load(user.picture).into(view.user_picture)

        view.user_name.text = user.name
        view.user_surname.text = user.surname
        view.user_email.text = user.email
        view.user_phone.text = user.phone

        view.favorite_button.setImageResource(getFavoriteButtonImage(user.isFavorite))

        view.user_picture.setOnClickListener { listener.onUserClicked(view.tag as User) }
        view.delete_user.setOnClickListener { listener.onDeleteUserClicked(view.tag as User) }
        view.favorite_button.setOnClickListener { listener.onFavoriteClicked(user) }
    }

    private fun getFavoriteButtonImage(favorite: Boolean) = if (favorite) {
        android.R.drawable.star_big_on
    } else {
        android.R.drawable.star_big_off
    }

}