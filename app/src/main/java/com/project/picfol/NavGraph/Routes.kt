package com.project.picfol.NavGraph

sealed class Routes(val route: String) {

    object OnBoardingScreen : Routes(route = "OnBoardingScreen")
    object AppStartNavigation : Routes(route = "AppStartNavigation")
    object SignInScreen : Routes(route = "SignInScreen")
    object SignUpScreen : Routes(route = "SignUpScreen")
    object BookShelfScreen : Routes(route = "BookShelfScreen")
    object EditorScreen : Routes(route = "EditorScreen")
    object ProfileScreen : Routes(route = "ProfileScreen")
    object SettingsProfileScreen : Routes(route = "SettingsProfileScreen")
}