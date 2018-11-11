package com.jmlb0003.randomcoapp.data.repository

import com.jmlb0003.randomcoapp.data.RepeatedUsersChecker
import com.jmlb0003.randomcoapp.data.UserApiClient
import com.jmlb0003.randomcoapp.data.network.UserParser
import com.jmlb0003.randomcoapp.data.network.servicemodel.UsersApiResponse
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.domain.repository.UsersRepository
import io.reactivex.Single
import java.io.IOException

private const val USERS_COUNT = 40

class UsersRepositoryImp(private val apiClient: UserApiClient,
                         private val parser: UserParser) : UsersRepository {

    override fun getUsers(): Single<List<User>> {
        return Single.create { emitter ->
            try {
                apiClient.getRandomUsers(USERS_COUNT).execute().body()?.let { response ->
                    val parsedResponse = parseResponse(response)
                    emitter.onSuccess(RepeatedUsersChecker.removeDuplicatedUsers(parsedResponse))
                }
            } catch (e: IOException) {
                emitter.onError(Throwable(e.message))
            }
            if (!emitter.isDisposed) {
                emitter.onError(Throwable("We had an issue downloading the users"))
            }
        }
    }

    private fun parseResponse(response: UsersApiResponse): List<User> = parser.parseUserResponse(response)

}
