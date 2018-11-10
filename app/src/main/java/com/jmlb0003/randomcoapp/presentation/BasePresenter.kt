package com.jmlb0003.randomcoapp.presentation

interface BasePresenter<V : BasePresenter.BaseView> {

    fun getView(): V?

    fun attachView(view: V)

    fun detachView()

    interface BaseView

}
