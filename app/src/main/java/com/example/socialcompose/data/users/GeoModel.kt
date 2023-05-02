package com.example.socialcompose.data.users


import com.google.gson.annotations.SerializedName

data class GeoModel(
    @SerializedName("lat")
    val lat: String? = "",
    @SerializedName("lng")
    val lng: String? = ""
)