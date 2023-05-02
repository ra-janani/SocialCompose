package com.example.socialcompose.ui

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.socialcompose.ui.navigation.Screen

@Composable
fun BackButton(navController: NavController) {
    IconButton(onClick = { navController.navigate("home_screen") })
    {
        //IconButton(onClick = { navController.navigateUp()}) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.White
        )
    }
}
