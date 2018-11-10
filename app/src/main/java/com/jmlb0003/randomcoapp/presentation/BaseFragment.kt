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

    protected abstract val presenter: P

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
        presenter.attachView(getMVPViewReference())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = isToBeRetained
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(getMVPViewReference())
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }

}