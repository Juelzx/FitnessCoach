package julian.scholler.fitnesscoach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import julian.scholler.fitnesscoach.helper.SharedPreferencesDelegate
import julian.scholler.fitnesscoach.landingpage.LandingScreen
import julian.scholler.fitnesscoach.ui.theme.FitnessCoachTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessCoachTheme {
                installSplashScreen()
                LandingScreen()
            }
        }
    }
}



