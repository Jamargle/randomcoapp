package com.jmlb0003.randomcoapp.data.repository

import com.jmlb0003.randomcoapp.domain.User
import com.jmlb0003.randomcoapp.domain.repository.UsersRepository

class UsersRepositoryImp : UsersRepository {

    override fun getUsers(): List<User> {
        return mutableListOf(User("pepe", "asdasdas"),
                User("pepe", "asdasdas"),
                User("pepe", "asdasdas"),
                User("pepe", "asdasdas"),
                User("pepe", "asdasdas"),
                User("pepe", "asdasdas"),
                User("pepe", "asdasdas"),
                User("pepe", "asdasdas"))
    }

}
