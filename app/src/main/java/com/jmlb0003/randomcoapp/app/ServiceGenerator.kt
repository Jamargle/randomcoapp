package com.jmlb0003.randomcoapp.app

import com.jmlb0003.randomcoapp.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BuildConfig.USERS_API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        val httpClient = OkHttpClient.Builder()
            .build()

        val retrofit = retrofitBuilder
            .client(httpClient)
            .build()
        return retrofit.create(serviceClass)
    }

}
