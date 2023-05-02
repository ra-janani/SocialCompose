package com.example.socialcompose.ui.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.socialcompose.R
import com.example.socialcompose.ui.SocialViewModel
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SplashScreen(
    viewModel: SocialViewModel = hiltViewModel(),
    navController: NavController
) {

    val splashColor =  Color(0xFFFFFF)
    Surface(color = splashColor) {
        Box(modifier = Modifier.fillMaxSize().background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            // Add your splash screen content here, such as a logo or image
            Image(
                painter = painterResource(id = R.drawable.social_logo),
                contentDescription = null,
                modifier = Modifier.size(250.dp)
            )
        }

        LaunchedEffect(Unit) {
            // Simulate a delay for the splash screen
            delay(2000)

            // Navigate to the next activity
            //navigateTo()
            navController.navigate("login_screen")
        }
    }

}