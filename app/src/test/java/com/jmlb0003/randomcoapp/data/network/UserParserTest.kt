package com.jmlb0003.randomcoapp.data.network

import com.jmlb0003.randomcoapp.TestData
import com.jmlb0003.randomcoapp.data.network.servicemodel.User
import com.jmlb0003.randomcoapp.data.network.servicemodel.UsersApiResponse
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class UserParserTest {

    private val parser: UserParser = UserParser

    @Test
    fun `return an empty list if the response is empty`() {
        val emptyResponse = mock<UsersApiResponse> {
            on { users } doReturn emptyList()
        }

        val result = parser.parseUserResponse(emptyResponse)

        assertTrue(result.isEmpty())
    }

    @Test
    fun `return a list of users from the given response`() {
        val response = mock<UsersApiResponse> {
            on { users } doReturn TestData.ListOfNetworkUsers.users
        }

        val result = parser.parseUserResponse(response)

        assertEquals(2, result.size)
        with(result[0]) {
            assertEquals(TestData.NetworkUser1.FIRST_NAME, name)
            assertEquals(TestData.NetworkUser1.LAST_NAME, surname)
            assertEquals(TestData.NetworkUser1.EMAIL1, email)
        }
    }

    @Test
    fun `set the first phone if is not null or blank`() {
        val phone = "123"
        val cellPhone = null
        val testResponseUsers: List<User> = listOf(User(null,
                null,
                null,
                null,
                null,
                null,
                null,
                phone,
                cellPhone,
                null,
                null,
                null))
        val response = mock<UsersApiResponse> {
            on { users } doReturn testResponseUsers
        }

        val result = parser.parseUserResponse(response)

        assertEquals(phone, result[0].phone)
    }

    @Test
    fun `set the cell phone if phone is null`() {
        val phone = null
        val cellPhone = "456"
        val testResponseUsers: List<User> = listOf(User(null,
                null,
                null,
                null,
                null,
                null,
                null,
                phone,
                cellPhone,
                null,
                null,
                null))
        val response = mock<UsersApiResponse> {
            on { users } doReturn testResponseUsers
        }

        val result = parser.parseUserResponse(response)

        assertEquals(cellPhone, result[0].phone)
    }

    @Test
    fun `set the cell phone if phone is blank`() {
        val phone = " "
        val cellPhone = "456"
        val testResponseUsers: List<User> = listOf(User(null,
                null,
                null,
                null,
                null,
                null,
                null,
                phone,
                cellPhone,
                null,
                null,
                null))
        val response = mock<UsersApiResponse> {
            on { users } doReturn testResponseUsers
        }

        val result = parser.parseUserResponse(response)

        assertEquals(cellPhone, result[0].phone)
    }

}