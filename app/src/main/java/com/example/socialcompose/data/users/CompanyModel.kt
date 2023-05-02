package com.example.socialcompose.data.users


import com.google.gson.annotations.SerializedName

data class CompanyModel(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("catchPhrase")
    val catchPhrase: String? = "",
    @SerializedName("bs")
    val bs: String? = ""
)