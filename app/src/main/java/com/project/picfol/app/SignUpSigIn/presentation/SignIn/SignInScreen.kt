package com.project.picfol.app.SignUpSigIn.presentation.SignIn


import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getString
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import com.project.picfol.R
import com.project.picfol.app.NavGraph.Routes
import com.project.picfol.app.SignUpSigIn.presentation.components.ButtonComponent
import com.project.picfol.app.SignUpSigIn.presentation.components.CheckBoxComponent
import com.project.picfol.app.SignUpSigIn.presentation.components.ClickableText
import com.project.picfol.app.SignUpSigIn.presentation.components.DivideLine
import com.project.picfol.app.SignUpSigIn.presentation.components.GoogleFacebookIcon
import com.project.picfol.app.SignUpSigIn.presentation.components.HeadingText
import com.project.picfol.app.SignUpSigIn.presentation.components.PasswordField
import com.project.picfol.app.SignUpSigIn.presentation.components.TextField
import com.project.picfol.ui.theme.DarkPurple
import kotlinx.coroutines.launch

@Composable
fun SignInScreen(
    navController: NavController,
    state: SignInState,
    onSignInClickGoogle: () -> Unit
) {
    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }

    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkPurple)
            .padding(28.dp),
        color = DarkPurple,

        ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            HeadingText("Log in")
            Spacer(modifier = Modifier.height(8.dp))
            TextField(email, labelValue = "email", R.drawable.email_icon)
            Spacer(modifier = Modifier.height(8.dp))
            PasswordField(password, labelValue = "password", R.drawable.password_icon)
            CheckBoxComponent(value = "You agree?")

            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponent(value = stringResource(id = R.string.signin_button_text)) {
                TODO()
            }
            Spacer(modifier = Modifier.height(10.dp))
            ClickableText(
                "Don`t have account? ",
                "Sign Up"
            ) { navController.navigate(Routes.SignUpScreen.route) }

            Spacer(modifier = Modifier.height(50.dp))
            DivideLine()

            Spacer(modifier = Modifier.height(50.dp))

            GoogleFacebookIcon(googleClick = onSignInClickGoogle) { TODO("Do facebook sign up") }


        }
    }
}