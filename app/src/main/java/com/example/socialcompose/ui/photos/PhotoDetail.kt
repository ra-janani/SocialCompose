package com.example.socialcompose.ui.photos

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.socialcompose.ui.SocialViewModel
import com.example.socialcompose.ui.users.ToolbarDetail

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PhotoDetail(
    navController: NavController,
    viewModel: SocialViewModel = hiltViewModel(),
    id: String
) {
    val state by viewModel.photos.collectAsState()
    Scaffold(
        topBar = { ToolbarDetail(navController, "Photos") }
    ) {
        viewModel.getPhotos(id)
        if (state.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                if (state.isNotEmpty()) {
                    items(state) {
                        Image(
                            painter = rememberAsyncImagePainter(it.url),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                                .size(200.dp)
                        )

                    }
                }

            }
        }

    }
}