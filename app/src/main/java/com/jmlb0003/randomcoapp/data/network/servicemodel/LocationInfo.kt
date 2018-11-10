package com.jmlb0003.randomcoapp.data.network.servicemodel

import com.google.gson.annotations.SerializedName

data class LocationInfo(@SerializedName("street") val street: String?,
                        @SerializedName("city") val city: String?,
                        @SerializedName("state") val state: String?,
                        @SerializedName("postcode") val postcode: Number?,
                        @SerializedName("coordinates") val coordinates: Coordinates?,
                        @SerializedName("timezone") val timezone: Timezone?)