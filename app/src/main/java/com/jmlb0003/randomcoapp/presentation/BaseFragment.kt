package com.jmlb0003.randomcoapp.presentation

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment<C, V : BasePresenter.BaseView, P : BasePresenter<V>> : Fragment(), BasePresenter.BaseView {

    protected var callback: C? = null

    @get:LayoutRes
    protected abstract val layoutResourceId: Int

    protected abstract fun getPresenter(): P

    protected abstract fun getMVPViewReference(): V

    /**
     * Control whether a fragment instance is retained across Activity re-creation (such as from
     * a configuration change)
     */
    protected val isToBeRetained: Boolean
        get() = false

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        @Suppress("UNCHECKED_CAST")
        callback = activity as? C ?:
                throw RuntimeException("${activity.toString()} must implement ${callback.toString()}")
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? = inflater.inflate(layoutResourceId, container, false)

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        getPresenter().attachView(getMVPViewReference())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = isToBeRetained
    }

    override fun onStart() {
        super.onStart()
        if (getPresenter().getView() == null) {
            getPresenter().attachView(getMVPViewReference())
        }
    }

    override fun onPause() {
        super.onPause()
        getPresenter().detachView()
    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }

    // TODO check if network is available
    protected fun hasNetworkConnection() = true

}