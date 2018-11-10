package com.jmlb0003.randomcoapp.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<V : BasePresenter.BaseView, P : BasePresenter<V>> : AppCompatActivity(),
                                                                                BasePresenter.BaseView {

    protected abstract val presenter: P

    protected abstract fun getMVPViewReference(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(getMVPViewReference())
    }

    override fun onPause() {
        super.onPause()
        presenter.attachView(getMVPViewReference())
    }

}
