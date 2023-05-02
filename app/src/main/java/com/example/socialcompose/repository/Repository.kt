package com.example.socialcompose.repository

import com.example.socialcompose.data.albums.AlbumsItemModel
import com.example.socialcompose.data.comments.CommentsItemModel
import com.example.socialcompose.data.photos.PhotosItemModel
import com.example.socialcompose.data.posts.PostsItemModel
import com.example.socialcompose.data.todos.TodosItemModel
import com.example.socialcompose.data.users.UsersItemModel

interface Repository {

    //suspend fun getTodos(id:String): List<TodosItemModel>
    suspend fun getTodos(): List<TodosItemModel>

    suspend fun getPosts(): List<PostsItemModel>

    suspend fun getUsers(): List<UsersItemModel>

    suspend fun getAlbums(id: String): List<AlbumsItemModel>

    suspend fun getPhotos(id: String): List<PhotosItemModel>

    suspend fun getComments(id: String): List<CommentsItemModel>
}