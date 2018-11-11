package com.jmlb0003.randomcoapp.domain.repository

import com.jmlb0003.randomcoapp.domain.model.User
import io.reactivex.Single

interface UsersRepository {

    fun getUsers(): Single<List<User>>

    fun swapFavorite(user: User): Single<User>

    fun removeUser(user: User): Single<User>

}
