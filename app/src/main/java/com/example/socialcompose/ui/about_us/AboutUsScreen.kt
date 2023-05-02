package com.example.socialcompose.ui.about_us

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.socialcompose.ui.todos.Toolbar
import com.example.socialcompose.ui.utils.ContactUtils.sendMail

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AboutUsScreen(navController: NavController) {


    Scaffold(
        topBar = { Toolbar(navController, "About Developer") }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(all = 12.dp)
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize(1f)
                    .background(
                        Brush.sweepGradient(
                            colors = listOf(
                                Color(0xFFffffff),
                                Color(0xFFE3E3E3)
                            )
                        )
                    )
            ) {
                Card(
                    elevation = 4.dp,
                    modifier = Modifier
                        .padding(32.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(16.dp, 24.dp)

                    ) {
                        Image(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Person",
                            modifier = Modifier
                                .size(240.dp),
                            alignment = Alignment.Center
                        )
                        Text(
                            text = "Janani Rajendran",
                            style = MaterialTheme.typography.h4,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(
                            text = "Android Developer",
                            style = MaterialTheme.typography.h5,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                        val context = LocalContext.current
                        Button(onClick = {
                            context.sendMail(to = "ra.janani@yahoo.co.in", subject = "Hello")
                        }) {
                            Text(
                                text = "Contact me",
                                style = MaterialTheme.typography.h6,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }

                    }

                }
            }
        }
    }


}