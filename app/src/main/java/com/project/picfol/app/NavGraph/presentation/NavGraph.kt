package com.project.picfol.app.NavGraph.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.project.picfol.app.NavGraph.Routes
import com.project.picfol.app.Profile.ProfileScreen
import com.project.picfol.app.SignUpSigIn.presentation.SignIn.SignInScreen
import com.project.picfol.app.SignUpSigIn.presentation.SignUp.SignUpScreen
import com.project.picfol.app.Welcome.presentation.WelcomeScreen
import com.project.picfol.app.Welcome.presentation.WelcomeViewModel

@Composable
fun NavGraph(
    startDestination: String = Routes.WelcomeScreen.route
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Routes.AppStartNavigation.route,
            startDestination = Routes.WelcomeScreen.route
        ){
            composable(
                route = Routes.WelcomeScreen.route
            ) {
                val viewModel: WelcomeViewModel = hiltViewModel()
                WelcomeScreen(event = viewModel::onEvent, navController)
            }
        }

        navigation(
            route = Routes.Registration.route,
            startDestination = Routes.SignInScreen.route
        ){
            composable(route = Routes.SignUpScreen.route) {
                SignUpScreen(navController = navController)
            }
            composable(route = Routes.SignInScreen.route) {
                SignInScreen(navController = navController)
            }
        }

        navigation(
            route = Routes.PicfolApp.route,
            startDestination = Routes.ProfileScreen.route
        ){
            composable(route = Routes.ProfileScreen.route) {
                ProfileScreen()
            }
        }

    }
}