package com.jmlb0003.randomcoapp.app.di

import com.jmlb0003.randomcoapp.data.RepeatedUsersChecker
import com.jmlb0003.randomcoapp.data.repository.UsersRepositoryImp
import com.jmlb0003.randomcoapp.domain.repository.UsersRepository

object RepositoryFactory {

    private val repeatedUsersCheckerInstance: RepeatedUsersChecker by lazy {
        RepeatedUsersChecker
    }
    private val usersRepositoryInstance: UsersRepository by lazy {
        UsersRepositoryImp(NetworkFactory.createRandomUserService(), NetworkFactory.createUserParser(),
                repeatedUsersCheckerInstance)
    }

    fun createUsersRepository(): UsersRepository = usersRepositoryInstance

}
