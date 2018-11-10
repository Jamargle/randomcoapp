package com.jmlb0003.randomcoapp.app.di

import com.jmlb0003.randomcoapp.domain.repository.UsersRepository

object RepositoryFactory {

    private val usersRepositoryInstance: UsersRepository by lazy { UsersRepository() }

    fun createUsersRepository(): UsersRepository = usersRepositoryInstance

}
