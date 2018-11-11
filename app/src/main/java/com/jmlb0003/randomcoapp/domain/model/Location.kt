package com.jmlb0003.randomcoapp.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(val street: String?,
                    val city: String?,
                    val state: String?,
                    val latitude: String?,
                    val longitude: String?) : Parcelable