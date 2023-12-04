package julian.scholler.fitnesscoach.helper

import android.content.Context

sealed class SharedPreferencesManager(context: Context) {
    
    var username by SharedPreferencesDelegate(context, "test", "")

}