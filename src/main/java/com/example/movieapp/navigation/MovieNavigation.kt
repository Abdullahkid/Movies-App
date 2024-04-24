package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.home.HomeScreen
import com.example.movieapp.screens.details.DetailsScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreens.name ){
        composable(MovieScreens.HomeScreens.name){
            //here we should pass where this should leave us to
            HomeScreen(navController)
        }
        composable(MovieScreens.DetailScreens.name+"/{movie}",
                  arguments = listOf(navArgument(name = "movie"){type =  NavType.StringType})
        ){
            backStackEntry->
            DetailsScreen(navController,movieId = backStackEntry.arguments?.getString("movie"))
        }
    }
}