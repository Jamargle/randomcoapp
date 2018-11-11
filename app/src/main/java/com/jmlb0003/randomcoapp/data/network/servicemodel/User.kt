package com.jmlb0003.randomcoapp.data.network.servicemodel

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("gender") val gender: String?,
                @SerializedName("name") val name: UserNameInfo?,
                @SerializedName("location") val location: LocationInfo?,
                @SerializedName("email") val email: String?,
                @SerializedName("login") val loginInformation: LoginInfo?,
                @SerializedName("dob") val birthday: DateOfBirthday?,
                @SerializedName("registered") val registered: Registered?,
                @SerializedName("phone") val phone: String?,
                @SerializedName("cell") val cell: String?,
                @SerializedName("id") val id: Id?,
                @SerializedName("picture") val picture: Picture?,
                @SerializedName("nat") val nationality: String?)
