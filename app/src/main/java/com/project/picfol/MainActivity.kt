package com.project.picfol

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Identity
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.project.picfol.app.NavGraph.Routes
import com.project.picfol.app.NavGraph.presentation.MainViewModel
import com.project.picfol.app.NavGraph.presentation.NavGraph
import com.project.picfol.app.Profile.ProfileScreen
import com.project.picfol.app.SignUpSigIn.presentation.GoogleAuthUiClient
import com.project.picfol.app.SignUpSigIn.presentation.SignIn.SignInScreen
import com.project.picfol.app.SignUpSigIn.presentation.SignIn.SignInViewModel
import com.project.picfol.app.SignUpSigIn.presentation.SignUp.SignUpScreen
import com.project.picfol.app.Welcome.presentation.WelcomeScreen
import com.project.picfol.app.Welcome.presentation.WelcomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.math.sign

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = com.google.android.gms.auth.api.identity.Identity.getSignInClient(applicationContext)
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.splashCondition
            }
        }

        setContent {
            val startDestination = viewModel.startDestination
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = startDestination) {
                navigation(
                    route = Routes.AppStartNavigation.route,
                    startDestination = Routes.WelcomeScreen.route
                ) {
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
                ) {
                    composable(route = Routes.SignUpScreen.route) {
                        SignUpScreen(navController = navController)
                    }
                    composable(route = Routes.SignInScreen.route) {
                        val viewModel = viewModel<SignInViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        LaunchedEffect(key1 = Unit) {
                            if(googleAuthUiClient.getSignIdUser() != null){
                                navController.navigate(Routes.PicfolApp.route)
                            }
                        }
                        val launcher =
                            rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.StartIntentSenderForResult(),
                                onResult = { result ->
                                    if (result.resultCode == RESULT_OK) {
                                        lifecycleScope.launch {
                                            val signInResult = googleAuthUiClient.signInWithIntent(
                                                intent = result.data ?: return@launch
                                            )
                                            viewModel.onSignInResult(signInResult)
                                        }
                                    }
                                }
                            )

                        LaunchedEffect(key1 = state.isSignInSuccess) {
                            if (state.isSignInSuccess){
                                Toast.makeText(
                                    applicationContext,
                                    "Sign in success",
                                    Toast.LENGTH_LONG
                                ).show()

                                navController.navigate(Routes.PicfolApp.route)
                                viewModel.resetState()
                            }
                        }

                        SignInScreen(
                            navController = navController,
                            state = state,
                            onSignInClickGoogle = {
                                lifecycleScope.launch {
                                    val signInIntentSender = googleAuthUiClient.signIn()
                                    launcher.launch(
                                        IntentSenderRequest.Builder(
                                            signInIntentSender ?: return@launch
                                        ).build()
                                    )
                                }
                            })
                    }
                }

                navigation(
                    route = Routes.PicfolApp.route,
                    startDestination = Routes.ProfileScreen.route
                ) {
                    composable(route = Routes.ProfileScreen.route) {
                        ProfileScreen(
                            userData = googleAuthUiClient.getSignIdUser(),
                            onSignOut = {
                                lifecycleScope.launch {
                                    googleAuthUiClient.signOut()
                                    Toast.makeText(
                                        applicationContext,
                                        "Sign out",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    navController.popBackStack()
                                }

                            }
                        )

                    }
                }
            }

        }
    }
}