package com.example.socialcompose.data.posts


import com.google.gson.annotations.SerializedName

data class PostsItemModel(
    @SerializedName("userId")
    val userId: Int? = 0,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("body")
    val body: String? = ""
)