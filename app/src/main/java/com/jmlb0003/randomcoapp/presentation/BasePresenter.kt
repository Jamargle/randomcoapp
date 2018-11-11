package com.jmlb0003.randomcoapp.presentation

import com.jmlb0003.randomcoapp.app.ErrorHandler

interface BasePresenter<V : BasePresenter.BaseView> {

    fun getView(): V?

    fun getErrorHandler(): ErrorHandler?

    fun attachView(view: V)

    fun detachView()

    interface BaseView

}
