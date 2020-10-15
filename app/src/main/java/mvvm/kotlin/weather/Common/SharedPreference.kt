package mvvm.kotlin.weather.Common

import android.content.Context
import android.util.Log
import mvvm.kotlin.weather.BuildConfig


object SharedPreference {

    private var context: Context? = null
    private const val appStorageName = BuildConfig.APPLICATION_ID

    fun init(c: Context?) {
        context = c
    }

    /***
     * Overloaders for Setting Shared Preferences
     * @param key
     * @param value
     */
    fun savePreference(key: String?, value: String?) {
        if (context == null) {
            Log.d("SharedPreference", "Error: Missing Context")
            return
        }
        val prefsEditor = context!!.getSharedPreferences(appStorageName,Context.MODE_PRIVATE ).edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
    }

    fun savePreference(key: String?, value: Int) {
        if (context == null) {
            Log.d("SharedPreference", "Error: Missing Context")
            return
        }
        val prefsEditor = context!!.getSharedPreferences(appStorageName,Context.MODE_PRIVATE ).edit()
        prefsEditor.putInt(key, value)
        prefsEditor.apply()
    }

    fun savePreference(key: String?, value: Float) {
        if (context == null) {
            Log.d("SharedPreference", "Error: Missing Context")
            return
        }
        val prefsEditor = context!!.getSharedPreferences(appStorageName,Context.MODE_PRIVATE ).edit()
        prefsEditor.putFloat(key, value)
        prefsEditor.apply()
    }

    fun savePreference(key: String?, value: Long) {
        if (context == null) {
            Log.d("SharedPreference", "Error: Missing Context")
            return
        }
        val prefsEditor = context!!.getSharedPreferences(appStorageName,Context.MODE_PRIVATE ).edit()
        prefsEditor.putLong(key, value)
        prefsEditor.apply()
    }

    fun savePreference(key: String?, value: Boolean?) {
        if (context == null) {
            Log.d("SharedPreference", "Error: Missing Context")
            return
        }
        val prefsEditor = context!!.getSharedPreferences(appStorageName,Context.MODE_PRIVATE ).edit()
        prefsEditor.putBoolean(key, value!!)
        prefsEditor.apply()
    }

    /***
     * Overloaders for Getting Shared Preferences
     * @param key
     * @param default_value
     * @return
     */
    fun loadPreference(key: String?, default_value: String?): String? {
        if (context == null) {
            Log.d("SharedPreference", "Error: Missing Context")
            return ""
        }
        val prefs = context!!.getSharedPreferences(appStorageName,Context.MODE_PRIVATE )
        return prefs.getString(key, default_value)
    }

    fun loadPreference(key: String?, default_value: Int): Int {
        if (context == null) {
            Log.d("SharedPreference", "Error: Missing Context")
            return -1
        }
        val prefs = context!!.getSharedPreferences(appStorageName,Context.MODE_PRIVATE )
        return prefs.getInt(key, default_value)
    }

    fun loadPreference(key: String?, default_value: Float): Float {
        if (context == null) {
            Log.d("SharedPreference", "Error: Missing Context")
            return (-1).toFloat()
        }
        val prefs = context!!.getSharedPreferences(appStorageName,Context.MODE_PRIVATE )
        return prefs.getFloat(key, default_value)
    }

    fun loadPreference(key: String?, default_value: Long): Long {
        if (context == null) {
            Log.d("SharedPreference", "Error: Missing Context")
            return -1
        }
        val prefs = context!!.getSharedPreferences(appStorageName,Context.MODE_PRIVATE )
        return prefs.getLong(key, default_value)
    }

    fun loadPreference(key: String?, default_value: Boolean?): Boolean {
        if (context == null) {
            Log.d("SharedPreference", "Error: Missing Context")
            return false
        }
        val prefs = context!!.getSharedPreferences(appStorageName,Context.MODE_PRIVATE )
        return prefs.getBoolean(key, default_value!!)
    }

    fun clearAll() {
        if (context == null) {
            Log.d("SharedPreference", "Error: Missing Context")
            return
        }
        val prefsEditor = context!!.getSharedPreferences(appStorageName,Context.MODE_PRIVATE ).edit()
        prefsEditor.clear()
        prefsEditor.apply()
    }
}
