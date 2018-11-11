package com.jmlb0003.randomcoapp.data

import com.jmlb0003.randomcoapp.TestData
import org.junit.Assert.assertEquals
import org.junit.Test

class RepeatedUsersCheckerTest {

    @Test
    fun `return one user if every users are the same`() {
        val duplicatedUsers = TestData.ListOfRepeatedUsers.users
        val checkedUsers = RepeatedUsersChecker.removeDuplicatedUsers(duplicatedUsers)
        assertEquals(1, checkedUsers.size)
    }

    @Test
    fun `return two users if every users are different`() {
        val users = TestData.ListOfNonRepeatedUsers.users
        val checkedUsers = RepeatedUsersChecker.removeDuplicatedUsers(users)
        assertEquals(2, checkedUsers.size)
    }

}