package com.jmlb0003.randomcoapp.domain.model

sealed class Gender(val description: String) {
    object Male : Gender("male")
    object Female : Gender("female")
    object Unknown : Gender("")
}