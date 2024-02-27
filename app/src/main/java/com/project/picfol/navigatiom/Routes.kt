package com.project.picfol.navigatiom

sealed class Routes(val route: String) {
    object MainScreen : Routes("main")
    object SplashScreen : Routes("splash")
    object WelcomeScreen : Routes("welcome")
    object SignInScreen : Routes("sign_in")
    object SignUpScreen : Routes("sign_uo")
}