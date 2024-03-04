package julian.scholler.fitnesscoach.googlesignin.view

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)
