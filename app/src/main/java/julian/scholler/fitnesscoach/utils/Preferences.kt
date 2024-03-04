package julian.scholler.fitnesscoach.utils

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {

    private var sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
    }

    companion object {
        private const val PREFERENCES = "PREFERENCES"

        // Profile
        private const val USER_CONFIG_DONE = "userConfig"
    }

    var userConfigDone: Boolean
    get() = sharedPreferences.getBoolean(USER_CONFIG_DONE, false)
        set(value) {
            sharedPreferences.edit().putBoolean(USER_CONFIG_DONE, value).apply()
        }
}