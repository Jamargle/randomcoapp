package com.jmlb0003.randomcoapp.presentation.userlist

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityPresenterTest {

    private val view = mock<MainActivityPresenter.MainActivityView>()
    private val presenter = MainActivityPresenter()

    @Before
    fun setUp() {
        presenter.attachView(view)
    }

    @After
    fun tearDown() {
        presenter.detachView()
    }

    @Test
    fun `call showLoading on onShowLoadingFromUsersFragment`() {
        presenter.onShowLoadingFromUsersFragment()
        verify(view).showLoading()
    }

    @Test
    fun `call hideLoading on onHideLoadingFromUsersFragment`() {
        presenter.onShowLoadingFromUsersFragment()
        verify(view).showLoading()
    }

}