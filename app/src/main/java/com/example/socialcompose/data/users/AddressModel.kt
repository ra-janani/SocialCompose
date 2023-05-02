package com.example.socialcompose.data.users


import com.google.gson.annotations.SerializedName

data class AddressModel(
    @SerializedName("street")
    val street: String? = "",
    @SerializedName("suite")
    val suite: String? = "",
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("zipcode")
    val zipcode: String? = "",
    @SerializedName("geo")
    val geo: GeoModel? = GeoModel()
)