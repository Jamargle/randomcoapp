package com.jmlb0003.randomcoapp.data.network

import com.jmlb0003.randomcoapp.data.network.servicemodel.LocationInfo
import com.jmlb0003.randomcoapp.data.network.servicemodel.Picture
import com.jmlb0003.randomcoapp.data.network.servicemodel.UsersApiResponse
import com.jmlb0003.randomcoapp.domain.model.Gender
import com.jmlb0003.randomcoapp.domain.model.Location
import com.jmlb0003.randomcoapp.domain.model.User
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val DATE_ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"

object UserParser {

    fun parseUserResponse(response: UsersApiResponse): List<User> =
        response.users.map { apiUser ->
            User(name = apiUser.name?.first ?: "",
                    surname = apiUser.name?.last ?: "",
                    email = apiUser.email ?: "",
                    picture = parsePicture(apiUser.picture),
                    phone = parsePhone(apiUser.phone, apiUser.cell),
                    gender = parseGender(apiUser.gender),
                    registeredDate = parseRegisteredDate(apiUser.registered?.date),
                    location = parseLocation(apiUser.location)
            )
        }

    private fun parsePhone(phone: String?, cellPhone: String?) =
        if (!phone.isNullOrBlank()) {
            phone
        } else if (!cellPhone.isNullOrBlank()) {
            cellPhone
        } else ""

    private fun parsePicture(picture: Picture?): String {
        picture?.let {
            return if (!it.medium.isNullOrBlank()) {
                it.medium
            } else if (!it.thumbnail.isNullOrBlank()) {
                it.thumbnail
            } else if (!it.large.isNullOrBlank()) {
                it.large
            } else {
                ""
            }
        }
        return ""
    }

    private fun parseGender(gender: String?): Gender = when (gender) {
        "male" -> Gender.Male
        "female" -> Gender.Female
        else -> Gender.Unknown
    }

    private fun parseRegisteredDate(date: String?): Date? =
        if (!date.isNullOrBlank()) {
            val formatter = SimpleDateFormat(DATE_ISO_8601_FORMAT, Locale.getDefault())
            try {
                formatter.parse(date)
            } catch (exception: ParseException) {
                null
            }
        } else {
            null
        }

    private fun parseLocation(location: LocationInfo?): Location =
        Location(street = location?.street,
                city = location?.city,
                state = location?.state,
                latitude = location?.coordinates?.latitude,
                longitude = location?.coordinates?.longitude)

}
