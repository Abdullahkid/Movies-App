package com.example.movieapp.navigation

enum class MovieScreens {
    HomeScreens,
    DetailScreens;
    companion object{
        fun fromRoute(route:String?):MovieScreens
        =when(route?.substringBefore("/")){
            HomeScreens.name -> HomeScreens
            DetailScreens.name -> DetailScreens
            null -> HomeScreens
            else -> throw IllegalArgumentException(
                  "Route $route is not recognized")

        }
    }
}