package com.example.socialcompose.ui.todos

import com.example.socialcompose.data.albums.AlbumsItemModel
import com.example.socialcompose.data.comments.CommentsItemModel
import com.example.socialcompose.data.photos.PhotosItemModel
import com.example.socialcompose.data.posts.PostsItemModel
import com.example.socialcompose.data.todos.TodosItemModel
import com.example.socialcompose.data.users.UsersItemModel
import com.example.socialcompose.repository.Repository

class FakeRepository: Repository {

     val todos= mutableListOf<TodosItemModel>()
    val posts= mutableListOf<PostsItemModel>()
    val users= mutableListOf<UsersItemModel>()
    val comments= mutableListOf<CommentsItemModel>()
    val albums= mutableListOf<AlbumsItemModel>()
    val photos= mutableListOf<PhotosItemModel>()


    override suspend fun getTodos(): List<TodosItemModel> {

        return todos.toList()

    }

    override suspend fun getPosts(): List<PostsItemModel> {
        return posts.toList()
    }

    override suspend fun getUsers(): List<UsersItemModel> {
        return users .toList()
    }

    override suspend fun getAlbums(id: String): List<AlbumsItemModel> {
        return albums .toList()
    }

    override suspend fun getPhotos(id: String): List<PhotosItemModel> {
        return photos .toList()
    }

    override suspend fun getComments(id: String): List<CommentsItemModel> {
        return  comments.toList()
    }

    fun addOrReplaceNewTodos(newTodo: TodosItemModel){
        val item=todos.find{it.id==newTodo.id}
        if(item==null)
            todos.add(newTodo)
        else
            item.apply{

                userId=newTodo.userId
                id=newTodo.id
                title=newTodo.title
                completed=newTodo.completed


            }

    }

    fun deleteTodos(todo: TodosItemModel){
        todos.remove(todo)
    }

    fun clearTodos(){
        todos.clear()
    }

}