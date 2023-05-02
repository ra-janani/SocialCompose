package com.example.socialcompose.remote

import com.example.socialcompose.data.albums.AlbumsItemModel
import com.example.socialcompose.data.comments.CommentsItemModel
import com.example.socialcompose.data.photos.PhotosItemModel
import com.example.socialcompose.data.posts.PostsItemModel
import com.example.socialcompose.data.todos.TodosItemModel
import com.example.socialcompose.data.users.UsersItemModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequest {


    @GET(ApiDetails.BASE_URL)
    //suspend fun getTodos(@Query("userId=id") id: String): List<TodosItemModel>
    suspend fun getTodos(): List<TodosItemModel>

    @GET(ApiDetails.POSTS)
    suspend fun getPosts(): List<PostsItemModel>

    @GET(ApiDetails.USERS)
    suspend fun getUsers(): List<UsersItemModel>

    @GET(ApiDetails.ALBUMS_WITH_ID)
    suspend fun getAlbums(@Path("id") id: String): List<AlbumsItemModel>

    @GET(ApiDetails.PHOTOS_WITH_ID)
    suspend fun getPhotos(@Path("id") id: String): List<PhotosItemModel>

    @GET(ApiDetails.COMMENTS_WITH_ID)
    suspend fun getComments(@Path("id") id: String): List<CommentsItemModel>

}