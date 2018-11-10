package com.jmlb0003.randomcoapp.domain.repository

import com.jmlb0003.randomcoapp.domain.User

class UsersRepository {

    fun getUsers(): List<User> {
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
