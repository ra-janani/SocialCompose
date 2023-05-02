package com.example.socialcompose.ui.todos


import com.example.socialcompose.data.todos.TodosItemModel
import com.example.socialcompose.ui.SocialViewModel
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SocialViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: SocialViewModel
    private lateinit var fakeRepository: FakeRepository


    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeRepository()
        viewModel = SocialViewModel(fakeRepository)
        fakeRepository.clearTodos()

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun viewModelTest_AddTodos() {

        val todoItem = TodosItemModel(
            userId = 1,
            id = 1,
            title = "Something",
            completed = false
        )

        fakeRepository.addOrReplaceNewTodos(todoItem)

        assertThat(fakeRepository.todos).isEqualTo(listOf(todoItem))
        assertThat(fakeRepository.todos[0].title).isEqualTo("Something")


    }


    @Test
    fun viewModelTest_delete_todo() {

        fakeRepository.clearTodos()
        val todoItem = TodosItemModel(
            userId = 27,
            id = 1,
            title = "Something",
            completed = false
        )

        val expectList = listOf(todoItem)
        //logic and verify
        fakeRepository.addOrReplaceNewTodos(todoItem)
        assertThat(fakeRepository.todos).isEqualTo(expectList)

        fakeRepository.deleteTodos(todoItem)
        assertThat(fakeRepository.todos).isNotEqualTo(expectList)


    }


    @Test
    fun viewModelTest_getTodos_emptyList() = runTest {

        fakeRepository.clearTodos()

        viewModel.getTodos()

        assertThat(viewModel._tasks.value).isEmpty()
    }


}