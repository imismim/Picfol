package com.project.picfol.app.NavGraph

sealed class Routes(val route: String) {

    object WelcomeScreen : Routes(route = "WelcomeScreen")
    object PicfolApp : Routes(route = "PicfolApp")

    object Registration: Routes(route = "Registration")
    object AppStartNavigation : Routes(route = "AppStartNavigation")

    object SignInScreen : Routes(route = "SignInScreen")
    object SignUpScreen : Routes(route = "SignUpScreen")
    object BookShelfScreen : Routes(route = "BookShelfScreen")
    object EditorScreen : Routes(route = "EditorScreen")
    object ProfileScreen : Routes(route = "ProfileScreen")
    object SettingsProfileScreen : Routes(route = "SettingsProfileScreen")
}