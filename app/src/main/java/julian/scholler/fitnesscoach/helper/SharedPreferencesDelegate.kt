package julian.scholler.fitnesscoach.helper

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SharedPreferencesDelegate<T>(
    private val context: Context,
    private val name: String,
    private val defaultValue: T
    ) : ReadWriteProperty<Any?, T> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        TODO("Not yet implemented")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        TODO("Not yet implemented")
    }

}