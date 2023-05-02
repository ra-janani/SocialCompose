package com.example.socialcompose.ui

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.socialcompose.ui.about_us.AboutUsScreen
import com.example.socialcompose.ui.comments.CommentsScreen
import com.example.socialcompose.ui.home.HomeScreen
import com.example.socialcompose.ui.login.LoginScreen
import com.example.socialcompose.ui.navigation.Screen
import com.example.socialcompose.ui.photos.PhotoDetail
import com.example.socialcompose.ui.splash.SplashScreen
import com.example.socialcompose.ui.todos.TodosScreen
import com.example.socialcompose.ui.users.FriendDetail
import com.example.socialcompose.ui.users.FriendsScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavGraph(auth: FirebaseAuth, prefs: SharedPreferences) {
    val socialViewModel = viewModel(modelClass = SocialViewModel::class.java)
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(Screen.Login.route) {
            LoginScreen(auth, navController = navController)
        }
        composable(Screen.Todo.route) {
            TodosScreen(
                socialViewModel,
                navController = navController
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(viewModel = socialViewModel,
                navController = navController,
                prefs)

        }

        composable(Screen.About.route) {
            AboutUsScreen(
                navController = navController
            )

        }
        composable(Screen.Users.route) {
            FriendsScreen(
                viewModel = socialViewModel,
                navController = navController,
                prefs
            )

        }
        composable(Screen.SplashScreen.route) {
            SplashScreen(
                viewModel = socialViewModel,
                navController = navController
            )

        }

        composable(
            Screen.FrndDetail.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) {
            FriendDetail(
                navController = navController,
                socialViewModel,
                it.arguments?.getInt("id").toString()

            )
        }

        composable(
            Screen.PhotoDetail.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) {
            PhotoDetail(
                navController = navController,
                socialViewModel,
                it.arguments?.getInt("id").toString()

            )
        }

        composable(
            Screen.CommentDetail.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) {
            CommentsScreen(
                navController = navController,
                socialViewModel,
                it.arguments?.getInt("id").toString()

            )
        }
    }

}