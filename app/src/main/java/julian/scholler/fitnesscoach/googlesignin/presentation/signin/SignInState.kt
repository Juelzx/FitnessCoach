package julian.scholler.fitnesscoach.googlesignin.presentation.signin

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)
