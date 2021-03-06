package com.jmlb0003.randomcoapp.data.repository

import com.jmlb0003.randomcoapp.data.RepeatedUsersChecker
import com.jmlb0003.randomcoapp.data.network.UserApiClient
import com.jmlb0003.randomcoapp.data.network.UserParser
import com.jmlb0003.randomcoapp.data.network.servicemodel.UsersApiResponse
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.domain.repository.UsersRepository
import io.reactivex.Single
import java.io.IOException

private const val USERS_COUNT = 40

class UsersRepositoryImp(private val apiClient: UserApiClient,
                         private val parser: UserParser,
                         private val repeatedUsersChecker: RepeatedUsersChecker) : UsersRepository {

    override fun getUsers(): Single<List<User>> {
        return Single.create { emitter ->
            try {
                apiClient.getRandomUsers(USERS_COUNT).execute().body()?.let { response ->
                    val parsedResponse = parseResponse(response)
                    emitter.onSuccess(repeatedUsersChecker.removeDuplicatedUsers(parsedResponse))
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

    override fun swapFavorite(user: User): Single<User> {
        return Single.create { emitter ->
            user.isFavorite = !user.isFavorite
            // TODO apply the change in the data source
            emitter.onSuccess(user)
        }
    }

    override fun removeUser(user: User): Single<User> {
        return Single.create { emitter ->
            // TODO Remove user from whatever source of data
            emitter.onSuccess(user)
            // TODO emitter.onError(Throwable("Error deleting the user"))
        }
    }

}
