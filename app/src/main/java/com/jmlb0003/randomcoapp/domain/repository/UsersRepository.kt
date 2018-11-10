package com.jmlb0003.randomcoapp.domain.repository

import com.jmlb0003.randomcoapp.domain.model.User

interface UsersRepository {

    fun getUsers(): List<User>

}
