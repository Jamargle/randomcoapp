package com.jmlb0003.randomcoapp.presentation.details

import android.os.Bundle
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.app.di.PresenterFactory
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.presentation.BaseFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.location_line1
import kotlinx.android.synthetic.main.fragment_details.location_line2
import kotlinx.android.synthetic.main.fragment_details.registered_date
import kotlinx.android.synthetic.main.fragment_details.user_email
import kotlinx.android.synthetic.main.fragment_details.user_gender
import kotlinx.android.synthetic.main.fragment_details.user_name
import kotlinx.android.synthetic.main.fragment_details.user_picture

class DetailsFragment : BaseFragment<DetailsFragment.Callback, DetailsPresenter.DetailsView, DetailsPresenter>(),
                        DetailsPresenter.DetailsView {

    override val layoutResourceId: Int
        get() = R.layout.fragment_details

    override fun getPresenter() = PresenterFactory.createUserDetailsPresenter()

    override fun getMVPViewReference(): DetailsPresenter.DetailsView = this

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val user = arguments?.getParcelable<User>(USER_TO_SHOW)
        getPresenter().onViewInitialized(user)
    }

    override fun showLoading() {
        callback?.onShowLoading()
    }

    override fun hideLoading() {
        callback?.onHideLoading()
    }

    override fun showUserName(name: String, surname: String) {
        user_name.text = "$name $surname"
    }

    override fun showUserEmail(email: String) {
        user_email.text = email
    }

    override fun showUserAddress(street: String, city: String, latitude: String, longitude: String) {
        location_line1.text = "$street, $city"
        location_line2.text = "Lat: $latitude  Lon: $longitude"
    }

    override fun showRegisterDate(parsedDate: String) {
        registered_date.text = "Registered since: $parsedDate"
    }

    override fun showGender(gender: String) {
        user_gender.text = gender
    }

    override fun showPicture(picturePath: String) {
        Picasso.with(activity)
            .load(picturePath)
            .fit().centerInside()
            .into(user_picture)
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
