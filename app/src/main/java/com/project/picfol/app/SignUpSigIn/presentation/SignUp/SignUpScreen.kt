package com.project.picfol.app.SignUpSigIn.presentation.SignUp

import android.widget.Toast
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
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
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    navController: NavController
) {
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
            var name = rememberSaveable { mutableStateOf("14") }
            var email = rememberSaveable { mutableStateOf("imismims@gmail.com") }
            var password = rememberSaveable { mutableStateOf("4545") }
            val scope = rememberCoroutineScope()
            val context = LocalContext.current
            val state = viewModel.signUpState.collectAsState(initial = null)


            Spacer(modifier = Modifier.height(100.dp))
            HeadingText("Create an Account")
            TextField(name, labelValue = "name", R.drawable.email_icon)
            Spacer(modifier = Modifier.height(8.dp))
            TextField(email, labelValue = "email", R.drawable.email_icon)
            Spacer(modifier = Modifier.height(8.dp))
            PasswordField(password, labelValue = "password", R.drawable.password_icon)
            CheckBoxComponent(value = "You agree?")

            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponent(value = stringResource(id = R.string.signup_button)) {
                scope.launch {
                    viewModel.signUpUser(email.value, password.value)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            ClickableText(
                "Already have account? ",
                "Log in"
            ) { navController.navigate(Routes.SignInScreen.route) }

            Spacer(modifier = Modifier.height(50.dp))
            DivideLine()

            Spacer(modifier = Modifier.height(50.dp))
            GoogleFacebookIcon({ TODO("Do google sign up") }, { TODO("Do acebook sign up") })

            LaunchedEffect(key1 = state.value?.isError?.isNotEmpty(), key2 = state.value?.isSuccess?.isNotEmpty()) {
                scope.launch {
                    if (state.value?.isError?.isNotEmpty() == true) {
                        val error = state.value?.isError
                        Toast.makeText(
                            context,
                            "${error} ${email.value}, ${password.value}",
                            Toast.LENGTH_LONG
                        ).show()
                    } else if (state.value?.isSuccess?.isNotEmpty() == true) {
                        Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
                        navController.navigate(route = Routes.PicfolApp.route)
                    }
                }
            }
        }
    }
}


//@Preview
//@Composable
//fun PrevSignUpScreen() {
//    SignUpScreen()
//}