package com.jmlb0003.randomcoapp.data.network.servicemodel

import com.google.gson.annotations.SerializedName

data class UserNameInfo(@SerializedName("title") val title: String?,
                        @SerializedName("first") val first: String?,
                        @SerializedName("last") val last: String?)