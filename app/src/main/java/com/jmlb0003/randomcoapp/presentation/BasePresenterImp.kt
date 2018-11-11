package com.jmlb0003.randomcoapp.presentation

import java.lang.ref.WeakReference

abstract class BasePresenterImp<V : BasePresenter.BaseView> : BasePresenter<V> {

    private var referenceView: WeakReference<V>? = null

    override fun getView(): V? {
        if (referenceView != null) {
            return referenceView?.get()
        } else {
            getErrorHandler()?.handleViewNullError(javaClass.simpleName)
        }
        return null
    }

    override fun attachView(view: V) {
        referenceView = WeakReference(view)
    }

    override fun detachView() {
        getView()?.let {
            referenceView!!.clear()
            referenceView = null
        }
    }

    fun onNoNetworkConnection() {
        // TODO Show a dialog to go to settings
    }

}
