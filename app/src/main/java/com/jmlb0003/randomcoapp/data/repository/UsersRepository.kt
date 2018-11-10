package com.jmlb0003.randomcoapp.data.repository

import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.domain.repository.UsersRepository

class UsersRepositoryImp : UsersRepository {

    override fun getUsers(): List<User> {
        return emptyList()
    }

}
