package com.jmlb0003.randomcoapp.domain.model

import android.os.Parcel
import android.os.Parcelable
import java.util.Date

data class User(val name: String,
                val surname: String,
                val email: String,
                val picture: String?,
                val phone: String?,
                val gender: Gender,
                val registeredDate: Date?,
                val location: Location,
                val isFavorite: Boolean = false) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            parcel.readString(),
            parcel.readString(),
            when (parcel.readString()) {
                "male" -> Gender.Male
                "female" -> Gender.Female
                else -> Gender.Unknown
            },
            Date(parcel.readLong()),
            parcel.readParcelable(Location::class.java.classLoader),
            parcel.readByte() != 0.toByte())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(surname)
        parcel.writeString(email)
        parcel.writeString(picture)
        parcel.writeString(phone)
        parcel.writeString(gender.description)
        parcel.writeLong(registeredDate?.time ?: 0)
        parcel.writeParcelable(location, flags)
        parcel.writeByte(if (isFavorite) 1 else 0)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User = User(parcel)
        override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
    }
}