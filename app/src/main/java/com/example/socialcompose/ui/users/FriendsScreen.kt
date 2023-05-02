package com.example.socialcompose.ui.users

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person2
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FriendsScreen(
    viewModel: SocialViewModel = hiltViewModel(),
    navController: NavController,
    prefs: SharedPreferences
) {

    val state by viewModel.users.collectAsState()
    val scrollPosition = prefs.getInt("scroll_position", 0)

    Scaffold(
        topBar = { Toolbar(navController, "FRIENDS") }
    ){
        viewModel.getUsers()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(all = 12.dp)
        ){
            val lazyListState = rememberLazyListState(
                initialFirstVisibleItemIndex = scrollPosition
            )

            LaunchedEffect(lazyListState) {
                snapshotFlow {
                    lazyListState.firstVisibleItemIndex
                }
                    .debounce(500L)
                    .collectLatest { index ->
                        prefs.edit()
                            .putInt("scroll_position", index)
                            .apply()
                    }
            }

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
                        .clickable { navController.navigate("frndDetail_screen/" +it.id) }
                    ) {

                        Row(modifier = Modifier.padding(16.dp)) {
                            Image(
                                imageVector = Icons.Filled.Person2,
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
                                    text = it.phone.toString(),
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