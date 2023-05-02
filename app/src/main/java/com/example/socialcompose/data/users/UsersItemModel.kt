package com.example.socialcompose.data.users


import com.google.gson.annotations.SerializedName

data class UsersItemModel(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("username")
    val username: String? = "",
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("address")
    val address: AddressModel? = AddressModel(),
    @SerializedName("phone")
    val phone: String? = "",
    @SerializedName("website")
    val website: String? = "",
    @SerializedName("company")
    val company: CompanyModel? = CompanyModel()
)