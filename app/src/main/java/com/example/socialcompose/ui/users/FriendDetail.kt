package com.example.socialcompose.ui.users

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.socialcompose.data.users.UsersItemModel
import com.example.socialcompose.ui.SocialViewModel

@Composable
fun FriendDetail(
    navController: NavController,
    viewModel: SocialViewModel = hiltViewModel(),
    id: String
) {

    val state by viewModel.users.collectAsState()
    Scaffold(
        topBar = { ToolbarDetail(navController, "Friend Details") }
    ) {

        viewModel.getUsers()
        if(state.isNotEmpty()){
            val result = state.find { it.id == id.toInt() }

            if (result != null) {
                CreateInfo(result, viewModel, navController)
            }
        }

    }

}


@Composable
private fun CreateInfo(
    random: UsersItemModel,
    viewModel: SocialViewModel = hiltViewModel(),
    navController: NavController,

) {

    val albumState by viewModel.album.collectAsState()
    viewModel.getAlbums((random.id).toString())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(all = 12.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(Color(0xFFffffff))
        ) {
            Row(
                modifier = Modifier
                    .padding(5.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Image(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person",
                    modifier = Modifier
                        .size(160.dp),
                    alignment = Alignment.Center
                )
                Column(

                    modifier = Modifier
                        .padding(all = 4.dp)
                ) {
                    Text(
                        color = Color.Blue,
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.h4,
                        text = random.name.toString()
                    )

                    Text(
                        text = (random.company?.name.toString()),
                        modifier = Modifier.padding(3.dp)

                    )

                    Text(
                        text = (random.address?.suite.toString()+
                                " ,"+random.address?.street.toString()+
                                " ,"+random.address?.city.toString()+
                                " ,"+random.address?.zipcode.toString()
                                ),
                        modifier = Modifier.padding(3.dp),
                    )

                }

            }

        }

        Spacer(modifier = Modifier.padding(4.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()

        ) {

            if (albumState.isNotEmpty()) {
                items(albumState) {
                    Card(
                        elevation = 4.dp,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { navController.navigate("photoDetail_screen/" +it.id) }

                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,

                            ) {
                            Text(
                                text = it.title.toString(),
                                style = MaterialTheme.typography.h5,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                }
            }

        }


    }
}

@Composable
fun ToolbarDetail(navController: NavController, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .height(56.dp)
            .background(Color(0xFF3700B3)),
        Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        BackButtonDetail(navController)
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

@Composable
fun BackButtonDetail(navController: NavController) {
        IconButton(onClick = { navController.navigateUp()}) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.White
        )
    }
}

