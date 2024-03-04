package julian.scholler.fitnesscoach

import android.os.Bundle
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import julian.scholler.fitnesscoach.view.profile.ProfileScreen
import julian.scholler.fitnesscoach.repository.signin.GoogleAuthUiClient
import julian.scholler.fitnesscoach.view.signin.SignInScreen
import julian.scholler.fitnesscoach.view.signin.SignInViewModel
import julian.scholler.fitnesscoach.ui.theme.FitnessCoachTheme
import julian.scholler.fitnesscoach.utils.Preferences
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    @Inject
    lateinit var googleAuthUiClient: GoogleAuthUiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreateMain")

        setContent {
            FitnessCoachTheme {
                installSplashScreen()

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "sign_in") {
                    composable("sign_in") {

                        val viewModel: SignInViewModel by viewModels()
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        // Unit makes it launch once
                        LaunchedEffect(key1 = Unit) {
                            if (googleAuthUiClient.getSignedInUser() != null) {
                                navController.navigate("profile")
                            }
                        }

                        val launcher = rememberLauncherForActivityResult(
                            contract = ActivityResultContracts.StartIntentSenderForResult(),
                            onResult = { result ->
                                if (result.resultCode == RESULT_OK)
                                    lifecycleScope.launch {
                                        val signInResult = googleAuthUiClient.signInWithIntent(
                                            intent = result.data ?: return@launch
                                        )
                                        viewModel.onSignInResult(signInResult)
                                    }
                            }
                        )

                        LaunchedEffect(key1 = state.isSignInSuccessful) {
                            if (state.isSignInSuccessful) {
                                Toast.makeText(
                                    applicationContext,
                                    "Successful",
                                    Toast.LENGTH_LONG
                                ).show()

                                navController.navigate("profile")
                                viewModel.resetState()
                            }
                        }


                        SignInScreen(state = state, onSignInClick = {
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

                    composable("profile") {
                        ProfileScreen(userData = googleAuthUiClient.getSignedInUser(),
                            onSignOut = {
                                lifecycleScope.launch {
                                    googleAuthUiClient.signOut()

                                    Toast.makeText(
                                        applicationContext,
                                        "Signed out",
                                        Toast.LENGTH_LONG
                                    ).show()

                                    navController.popBackStack()
                                }
                            }, onUserDetails = { navController.navigate("user_configuration") })

                    }
                }
            }
        }
    }
}






