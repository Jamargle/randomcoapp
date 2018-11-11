package com.jmlb0003.randomcoapp.data.network.servicemodel

import com.google.gson.annotations.SerializedName

//If the API keys change, we do not need to change the members names so our code will not be affected because of API changes
data class UsersApiResponse(@SerializedName("results") val users: List<User> = emptyList())
