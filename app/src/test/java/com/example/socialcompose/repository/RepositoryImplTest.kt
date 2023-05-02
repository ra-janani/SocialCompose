package com.example.socialcompose.repository

import com.example.socialcompose.data.todos.TodosItemModel
import com.example.socialcompose.remote.ApiRequest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RepositoryImplTest {

    @Mock
    lateinit var apiRequest: ApiRequest

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testGetTodos_EmptyList() = runTest {
        Mockito.`when`(apiRequest.getTodos()).thenReturn(arrayListOf())

        val repo = RepositoryImpl(apiRequest)
        val result = repo.getTodos()
        assertEquals(0, result.size)
    }

    @Test
    fun testGetTodos_expectedTodosList() = runTest {
        val todoList: ArrayList<TodosItemModel> = arrayListOf()
        todoList.add(
            TodosItemModel(
                27,
                1,
                "Something",
                false,

                )
        )
        todoList.add(
            TodosItemModel(
                27,
                2,
                "Something something",
                true,

                )
        )


        Mockito.`when`(apiRequest.getTodos()).thenReturn(todoList)

        val repo = RepositoryImpl(apiRequest)
        val result = repo.getTodos()
        assertEquals(2, result.size)
        assertEquals(true, result[1].completed)
    }

    @Test
    fun testGetTodos_expectedTodosList_not_match() = runTest {
        val todoList: ArrayList<TodosItemModel> = arrayListOf()
        todoList.add(
            TodosItemModel(
                27,
                1,
                "Something",
                false,
            )
        )



        Mockito.`when`(apiRequest.getTodos()).thenReturn(todoList)

        val repo = RepositoryImpl(apiRequest)
        val result = repo.getTodos()
        assertNotEquals(3, result.size)
        assertNotEquals("something", result[0].title)

    }

}