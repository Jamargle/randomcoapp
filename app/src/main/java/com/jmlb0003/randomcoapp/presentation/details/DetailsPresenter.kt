package com.jmlb0003.randomcoapp.presentation.details

import com.jmlb0003.randomcoapp.app.ErrorHandler
import com.jmlb0003.randomcoapp.presentation.BasePresenter
import com.jmlb0003.randomcoapp.presentation.BasePresenterImp

class DetailsPresenter(private val errorHandler: ErrorHandler) : BasePresenterImp<DetailsPresenter.DetailsView>() {

    override fun getErrorHandler(): ErrorHandler? = errorHandler

    fun onViewInitialized() {
        getView()?.let {
            it.showLoading()
            it.showUserDetails()
        }
    }

    interface DetailsView : BasePresenter.BaseView {

        fun showLoading()

        fun hideLoading()

        fun showUserDetails()

        fun showError(errorMessage: String)

    }

}
