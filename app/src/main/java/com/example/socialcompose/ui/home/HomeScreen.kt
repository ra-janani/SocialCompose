package com.example.socialcompose.ui.home

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
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.socialcompose.ui.components.AppBar
import com.example.socialcompose.ui.components.DrawerBody
import com.example.socialcompose.ui.components.DrawerHeader
import com.example.socialcompose.ui.SocialViewModel
import com.example.socialcompose.ui.theme.c1
import com.example.socialcompose.ui.theme.c2
import com.example.socialcompose.ui.utils.MenuItem
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel: SocialViewModel = hiltViewModel(),
    navController: NavController,
    prefs: SharedPreferences
) {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()


    val state by viewModel.posts.collectAsState()
    val scrollPositionHome = prefs.getInt("scroll_position", 0)
    viewModel.getPosts()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            DrawerHeader()
            DrawerBody(
                items = listOf(
                    MenuItem(
                        id = "home",
                        title = "Home",
                        contentDescription = "Go to home screen",
                        icon = Icons.Default.Home
                    ),
                    MenuItem(
                        id = "friend",
                        title = "Friends",
                        contentDescription = "Go to Friends screen",
                        icon = Icons.Default.Person
                    ),
                    MenuItem(
                        id = "todos",
                        title = "Todos",
                        contentDescription = "Go to Todos screen",
                        icon = Icons.Default.DateRange
                    ),
                    MenuItem(
                        id = "about_us",
                        title = "About Us",
                        contentDescription = "About Us",
                        icon = Icons.Default.Info
                    ),
                    MenuItem(
                        id = "log_out",
                        title = "Log Out",
                        contentDescription = "Log Out",
                        icon = Icons.Default.ExitToApp
                    ),
                ),

                onItemClick = {

                    when (it.id) {
                        "home" -> {
                            navController.navigate("home_screen")
                        }
                        "friend" -> {
                            navController.navigate("friend_screen")
                        }
                        "todos" -> {
                            navController.navigate("todo_screen")
                        }

                        "about_us" -> {
                            navController.navigate("about_screen")
                        }
                        "log_out" -> {
                            navController.navigate("login_screen")
                        }
                    }
                }
            )
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(all = 12.dp)
        ) {
            val lazyListState = rememberLazyListState(
                initialFirstVisibleItemIndex = scrollPositionHome
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
//                                .wrapContentSize(align = Alignment.Center)
                        )
                    }

                }

                items(state) {
                    Card(
                        elevation = 4.dp,
                        modifier = Modifier
                            .padding(8.dp)
                            .background(brush= Brush.linearGradient(
                                colors=listOf(
                                    c1,
                                    c2
                                )
                            ))
                            .clickable { navController.navigate("commentDetail_screen/" +it.id) }
                    ) {
                        Row(modifier = Modifier.padding(16.dp)) {
                            Image(
                                imageVector = Icons.Filled.FormatQuote,
                                colorFilter = ColorFilter.tint(Color.White),
                                alignment = Alignment.TopStart,
                                contentDescription = "Post",
                                modifier = Modifier
                                    .size(40.dp)
                                    .rotate(180F)
                                    .background(Color.Black)
                            )
                            Spacer(modifier = Modifier.padding(4.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = it.title.toString(),
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

    @Composable
    fun Toolbar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
                .height(56.dp)
                .background(Color(0xFF22324C)),
            Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Homescreen",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFC1D6F8),
                modifier = Modifier
                    .padding(10.dp)
            )
        }

    }
}