package com.jmlb0003.randomcoapp.presentation.details

import com.jmlb0003.randomcoapp.app.ErrorHandler
import com.jmlb0003.randomcoapp.domain.model.User
import com.jmlb0003.randomcoapp.presentation.BasePresenter
import com.jmlb0003.randomcoapp.presentation.BasePresenterImp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailsPresenter(private val errorHandler: ErrorHandler) : BasePresenterImp<DetailsPresenter.DetailsView>() {

    override fun getErrorHandler(): ErrorHandler? = errorHandler

    fun onViewInitialized(user: User?) {
        getView()?.let { view ->
            view.showLoading()

            user?.let {
                view.showUserName(user.name, user.surname)
                view.showUserEmail(user.email)
                with(user.location) {
                    view.showUserAddress(street ?: "", city ?: "", latitude ?: "", longitude ?: "")
                }

                val date = parseDate(user.registeredDate)
                if (!date.isBlank()) {
                    view.showRegisterDate(date)
                }
                view.showGender(user.gender.description)
                user.picture?.let { picture -> view.showPicture(picture) }
            }

            view.hideLoading()
        }
    }

    private fun parseDate(registeredDate: Date?): String =
        registeredDate?.let {
            SimpleDateFormat("dd MM yyyy", Locale.getDefault()).format(registeredDate)
        } ?: ""

    interface DetailsView : BasePresenter.BaseView {

        fun showLoading()

        fun hideLoading()

        fun showUserName(name: String, surname: String)

        fun showUserEmail(email: String)

        fun showUserAddress(street: String, city: String, latitude: String, longitude: String)

        fun showRegisterDate(parsedDate: String)

        fun showGender(gender: String)

        fun showPicture(picturePath: String)

        fun showError(errorMessage: String)

    }

}
