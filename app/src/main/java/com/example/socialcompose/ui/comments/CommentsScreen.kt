package com.example.socialcompose.ui.comments

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.socialcompose.ui.SocialViewModel
import com.example.socialcompose.ui.todos.Toolbar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CommentsScreen(
    navController: NavController,
    viewModel: SocialViewModel = hiltViewModel(),
    id: String
) {

    val state by viewModel.comments.collectAsState()

    Scaffold(
        topBar = { Toolbar(navController, "Comments") }
    ){
        viewModel.getComments(id)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(all = 12.dp)
        ){

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

                items(state) {
                    Card(
                        elevation = 4.dp,
                        modifier = Modifier
                            .padding(8.dp)

                    ) {

                        Row(modifier = Modifier.padding(16.dp)) {
                            Image(
                                imageVector = Icons.Filled.Comment,
                                colorFilter = ColorFilter.tint(Color.White),
                                alignment = Alignment.TopStart,
                                contentDescription = "Users",
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(Color.Black)
                            )
                            Spacer(modifier = Modifier.padding(4.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = it.name.toString(),
                                    style = MaterialTheme.typography.body2,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .background(Color(0xFEEEEEEE))
                                        .fillMaxWidth(.4f)
                                        .height(1.dp)
                                )
                                Text(
                                    text = it.email.toString(),
                                    style = MaterialTheme.typography.body2,
                                    modifier = Modifier.padding(top = 4.dp),
                                    fontWeight = FontWeight.Normal
                                )
                                Text(
                                    text = it.body.toString(),
                                    style = MaterialTheme.typography.body2,
                                    modifier = Modifier.padding(top = 4.dp),
                                    fontWeight = FontWeight.Normal
                                )


                            }
                        }
                    }
                }

            }

        }

    }

}