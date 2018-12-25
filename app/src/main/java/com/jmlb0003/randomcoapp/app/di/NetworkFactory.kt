package com.jmlb0003.randomcoapp.app.di

import com.jmlb0003.randomcoapp.data.network.ServiceGenerator
import com.jmlb0003.randomcoapp.data.network.UserApiClient
import com.jmlb0003.randomcoapp.data.network.UserParser

object NetworkFactory {

    private val randomUserServiceInstance: UserApiClient by lazy {
        ServiceGenerator.createService(UserApiClient::class.java)
    }

    fun createRandomUserService(): UserApiClient = randomUserServiceInstance

    fun createUserParser(): UserParser = UserParser

}
