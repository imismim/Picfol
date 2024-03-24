package com.project.picfol.NavGraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(
    startDestination: String
) {
     val navController = rememberNavController()

     NavHost(navController = navController, startDestination = startDestination){
          navigation(
               route = Routes.OnBoardingScreen.route,
               startDestination = Routes.OnBoardingScreen.route
          ){
               composable(
                    route = Routes.OnBoardingScreen.route
               ){

               }
               composable(
                    route = Routes.SignUpScreen.route
               ){

               }
          }
     }
}