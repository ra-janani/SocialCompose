package com.example.socialcompose.repository

import com.example.socialcompose.data.albums.AlbumsItemModel
import com.example.socialcompose.data.comments.CommentsItemModel
import com.example.socialcompose.data.photos.PhotosItemModel
import com.example.socialcompose.data.posts.PostsItemModel
import com.example.socialcompose.data.todos.TodosItemModel
import com.example.socialcompose.data.users.UsersItemModel
import com.example.socialcompose.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiRequest: ApiRequest
    ) : Repository {

    //override suspend fun getTodos(id:String):List<TodosItemModel> = apiRequest.getTodos(id)

    override suspend fun getTodos():List<TodosItemModel> = apiRequest.getTodos()

    override suspend fun getPosts(): List<PostsItemModel> = apiRequest.getPosts()

    override suspend fun getUsers(): List<UsersItemModel> = apiRequest.getUsers()

    override suspend fun getAlbums(id: String): List<AlbumsItemModel>  = apiRequest.getAlbums(id)

    override suspend fun getPhotos(id: String): List<PhotosItemModel>  = apiRequest.getPhotos(id)

    override suspend fun getComments(id: String): List<CommentsItemModel>  = apiRequest.getComments(id)
    }