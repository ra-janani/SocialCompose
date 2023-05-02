package com.example.socialcompose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialcompose.data.albums.AlbumsItemModel
import com.example.socialcompose.data.comments.CommentsItemModel
import com.example.socialcompose.data.photos.PhotosItemModel
import com.example.socialcompose.data.posts.PostsItemModel
import com.example.socialcompose.data.todos.TodosItemModel
import com.example.socialcompose.data.users.UsersItemModel
import com.example.socialcompose.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SocialViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    val _tasks = MutableStateFlow(listOf<TodosItemModel>())
    var tasks: StateFlow<List<TodosItemModel>> = _tasks


    init {
        getTodos()
    }


    fun getTodos() {

        viewModelScope.launch {
            _tasks.value = repository.getTodos()
        }
    }

    private val _posts = MutableStateFlow(listOf<PostsItemModel>())
    var posts: StateFlow<List<PostsItemModel>> = _posts


    fun getPosts() {

        viewModelScope.launch {
            _posts.value = repository.getPosts()
        }
    }

    private val _users = MutableStateFlow(listOf<UsersItemModel>())
    var users: StateFlow<List<UsersItemModel>> = _users


    fun getUsers() {

        viewModelScope.launch {
            _users.value = repository.getUsers()
        }
    }


    private val _albums = MutableStateFlow(listOf<AlbumsItemModel>())
    var album: StateFlow<List<AlbumsItemModel>> = _albums

    fun getAlbums(id:String) {

        viewModelScope.launch {
            _albums.value = repository.getAlbums(id)
        }
    }

    private val _photos = MutableStateFlow(listOf<PhotosItemModel>())
    var photos: StateFlow<List<PhotosItemModel>> = _photos

    fun getPhotos(albumId:String) {

        viewModelScope.launch {
            _photos.value = repository.getPhotos(albumId)
        }
    }

    private val _comments = MutableStateFlow(listOf<CommentsItemModel>())
    var comments: StateFlow<List<CommentsItemModel>> = _comments

    fun getComments(postId:String) {

        viewModelScope.launch {
            _comments.value = repository.getComments(postId)
        }
    }


}
