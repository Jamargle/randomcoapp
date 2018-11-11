package com.jmlb0003.randomcoapp.data

import com.jmlb0003.randomcoapp.domain.model.User

object UsersSorter {

    fun sortByName(users: List<User>) = users.sortedBy { it.name }

}
