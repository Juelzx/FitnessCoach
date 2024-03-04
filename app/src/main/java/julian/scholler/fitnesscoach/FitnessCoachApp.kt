package julian.scholler.fitnesscoach

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class FitnessCoachApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.uprootAll()

        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}