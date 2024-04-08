package com.project.picfol.app.NavGraph.presentation

import android.app.Activity.RESULT_OK
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.project.picfol.app.NavGraph.Routes
import com.project.picfol.app.Profile.ProfileScreen
import com.project.picfol.app.SignUpSigIn.presentation.SignIn.SignInScreen
import com.project.picfol.app.SignUpSigIn.presentation.SignIn.SignInViewModel
import com.project.picfol.app.SignUpSigIn.presentation.SignUp.SignUpScreen
import com.project.picfol.app.Welcome.presentation.WelcomeScreen
import com.project.picfol.app.Welcome.presentation.WelcomeViewModel
import androidx.lifecycle.lifecycleScope
import com.project.picfol.app.SignUpSigIn.presentation.GoogleAuthUiClient
import kotlinx.coroutines.launch

@Composable
fun NavGraph(
    startDestination: String = Routes.WelcomeScreen.route,
    ScopeLife: LifecycleCoroutineScope,
    googleAuthUiClient: GoogleAuthUiClient
) {

}