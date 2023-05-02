package com.example.socialcompose.ui.todos

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.socialcompose.R
import com.example.socialcompose.data.todos.TodosItemModel
import com.example.socialcompose.ui.BackButton
import com.example.socialcompose.ui.SocialViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TodosScreen(socialViewModel: SocialViewModel = hiltViewModel(), navController: NavController) {

    val state by socialViewModel.tasks.collectAsState()


    Scaffold(
        topBar = { Toolbar(navController, "List of Todos") }
    ) {
        socialViewModel.getTodos()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(all = 12.dp)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()

            ) {

                if (state.isEmpty()) {
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxSize()

                        )
                    }

                }

                items(state) { todos: TodosItemModel ->

                    Card(
                        elevation = 4.dp,
                        modifier = Modifier
                            .padding(8.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.Center,

                            ) {
                            Text(
                                text = todos.title.toString(),
                                style = MaterialTheme.typography.h5,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                                textAlign = TextAlign.Left
                            )

                            Spacer(modifier = Modifier.padding(4.dp))

                            if (todos.completed == true) {
                                Image(
                                    painter = painterResource(id = R.drawable.check_mark),
                                    contentDescription = "Person",
                                    modifier = Modifier
                                        .size(28.dp),
                                    alignment = Alignment.Center,
                                )
                            }

                        }
                    }

                }
            }
        }
    }

}

@Composable
fun Toolbar(navController: NavController, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .height(56.dp)
            .background(Color(0xFF3700B3)),
        Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        BackButton(navController)
        Text(

            text = title,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFFFFF),
            modifier = Modifier
                .padding(10.dp)
                .weight(1F),
        )

    }

}