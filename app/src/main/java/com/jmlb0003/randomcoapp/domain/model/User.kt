package com.jmlb0003.randomcoapp.domain.model

import java.util.Date

data class User(val name: String,
                val surname: String,
                val email: String,
                val picture: String?,
                val phone: String?,
                val gender: Gender,
                val registeredDate: Date?,
                val location: Location,
                val isFavorite: Boolean = false)