package com.jmlb0003.randomcoapp.presentation.details

import android.os.Bundle
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.app.di.PresenterFactory
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.presentation.BaseFragment

class DetailsFragment : BaseFragment<DetailsFragment.Callback, DetailsPresenter.DetailsView, DetailsPresenter>(),
                        DetailsPresenter.DetailsView {

    override val layoutResourceId: Int
        get() = R.layout.fragment_details

    override fun getPresenter() = PresenterFactory.createUserDetailsPresenter()

    override fun getMVPViewReference(): DetailsPresenter.DetailsView = this

    override fun showLoading() {
        callback?.onShowLoading()
    }

    override fun hideLoading() {
        callback?.onHideLoading()
    }

    override fun showUserDetails() {
        
    }

    override fun showError(errorMessage: String) {
        callback?.onShowError(errorMessage)
    }

    interface Callback {

        fun onShowLoading()

        fun onHideLoading()

        fun onShowError(errorMessage: String)

    }

    companion object {

        private const val USER_TO_SHOW = "DetailsFragment:user_to_show"

        fun newInstance(user: User) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_TO_SHOW, user)
            }
        }
    }
}
