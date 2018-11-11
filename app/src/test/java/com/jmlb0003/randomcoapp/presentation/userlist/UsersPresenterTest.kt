package com.jmlb0003.randomcoapp.presentation.userlist

import com.jmlb0003.randomcoapp.MockSchedulers
import com.jmlb0003.randomcoapp.TestData
import com.jmlb0003.randomcoapp.data.UsersSorter
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.domain.repository.UsersRepository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UsersPresenterTest {

    private val repository = mock<UsersRepository>()
    private val schedulers = MockSchedulers
    private val sorter = UsersSorter
    private val view = mock<UsersPresenter.UsersView>()

    private val presenter: UsersPresenter = UsersPresenter(repository, schedulers, sorter)

    @Before
    fun setUp() {
        presenter.attachView(view)
    }

    @After
    fun tearDown() {
        presenter.detachView()
    }

    @Test
    fun `retrieve users from repository on onViewInitialized`() {
        val expectedUsers: List<User> = TestData.ListOfNonRepeatedUsers.users
        whenever(repository.getUsers()).thenReturn(Single.just(expectedUsers))

        presenter.onViewInitialized()

        verify(repository, times(1)).getUsers()
    }

    @Test
    fun `call showUsers with users from repository on onViewInitialized`() {
        val expectedUsers = TestData.ListOfNonRepeatedUsers.users
        whenever(repository.getUsers()).thenReturn(Single.just(expectedUsers))

        presenter.onViewInitialized()

        verify(view, times(1)).showUsers(any())
    }

    @Test
    fun `show users sort users by name on onViewInitialized`() {
        val expectedUsers: List<User> = listOf(TestData.User1.USER.copy(name = "b"),
                TestData.User1.USER.copy(name = "c"),
                TestData.User1.USER.copy(name = "a"))
        whenever(repository.getUsers()).thenReturn(Single.just(expectedUsers))

        presenter.onViewInitialized()

        argumentCaptor<List<User>>().apply {
            verify(view, times(1)).showUsers(capture())

            assertEquals("a", firstValue[0].name)
            assertEquals("b", firstValue[1].name)
            assertEquals("c", firstValue[2].name)
        }
    }

}