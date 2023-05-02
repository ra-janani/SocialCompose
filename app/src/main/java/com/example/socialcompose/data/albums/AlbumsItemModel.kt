package com.example.socialcompose.data.albums


import com.google.gson.annotations.SerializedName

data class AlbumsItemModel(
    @SerializedName("userId")
    val userId: Int? = 0,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("title")
    val title: String? = ""
)