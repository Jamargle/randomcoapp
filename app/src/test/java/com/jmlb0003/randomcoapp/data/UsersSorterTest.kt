package com.jmlb0003.randomcoapp.data

import com.jmlb0003.randomcoapp.TestData
import com.jmlb0003.randomcoapp.domain.model.User
import org.junit.Assert.assertEquals
import org.junit.Test

class UsersSorterTest {

    @Test
    fun `sort users by name on sortByName`() {
        val users: List<User> = listOf(TestData.User1.USER.copy(name = "b"),
                TestData.User1.USER.copy(name = "c"),
                TestData.User1.USER.copy(name = "a"))

        val sortedUsers = UsersSorter.sortByName(users)

        assertEquals("a", sortedUsers[0].name)
        assertEquals("b", sortedUsers[1].name)
        assertEquals("c", sortedUsers[2].name)
    }
}