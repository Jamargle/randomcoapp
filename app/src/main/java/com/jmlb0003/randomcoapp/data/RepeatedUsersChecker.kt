package com.jmlb0003.randomcoapp.data

import com.jmlb0003.randomcoapp.domain.model.User

object RepeatedUsersChecker {

    fun removeDuplicatedUsers(rawUsers: List<User>) = rawUsers.distinctBy { user -> user.email }

}
