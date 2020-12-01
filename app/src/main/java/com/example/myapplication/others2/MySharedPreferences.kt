package com.example.myapplication.others2

import android.content.Context

class MySharedPreferences(context: Context) {
    //nombre fichero shared preferences
    private val fileName = "mis_preferencias"
    //instancia del fichero
    private val prefs = context.getSharedPreferences(fileName,Context.MODE_PRIVATE)
    // por cada una d elas variables que vamos a guardar en nuestro fichero  shared preferences
    var name: String
        get() = prefs.getString("name", "")
        set(value) = prefs.edit().putString("name", value).apply()

    var age: Int
        get() = prefs.getInt("name", -1)
        set(value) = prefs.edit().putInt("name", value).apply()

}