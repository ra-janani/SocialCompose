package com.example.socialcompose.ui.navigation

sealed class Screen(val route:String){

    object Login: Screen(route="login_screen")
    object Todo: Screen(route="todo_screen")
    object Home: Screen(route="home_screen")
    object About: Screen(route="about_screen")
    object Users: Screen(route="friend_screen")
    object FrndDetail: Screen(route="frndDetail_screen/{id}")
    object PhotoDetail: Screen(route="photoDetail_screen/{id}")
    object CommentDetail: Screen(route="commentDetail_screen/{id}")
    object SplashScreen: Screen(route="splash_screen")

}
