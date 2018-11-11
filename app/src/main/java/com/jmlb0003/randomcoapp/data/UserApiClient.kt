package com.jmlb0003.randomcoapp.data

import com.jmlb0003.randomcoapp.data.network.servicemodel.UsersApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val KEY_NUMBER = "results"
private const val KEY_FORMAT = "format"

interface UserApiClient {

    /**
     * Method to fetch a list of random users contained in a [UserApiResponse] object.
     *
     * @param numberOfUsers The amount of users you want to retrieve
     * @param responseFormat Type of the response. The request will be performed for JSON by default
     * @return [Call] object with the response containing random users that might be repeated
     */
    @GET("api/")
    fun getRandomUsers(@Query(KEY_NUMBER) numberOfUsers: Int,
                       @Query(KEY_FORMAT) responseFormat: String = "json"): Call<UsersApiResponse>

}
