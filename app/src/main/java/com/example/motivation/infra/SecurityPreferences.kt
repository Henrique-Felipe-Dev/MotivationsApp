package com.example.motivation.infra

import android.content.Context
import com.example.motivation.util.Constants

class SecurityPreferences (context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(chave: String, valor: String){
        sharedPreferences.edit().putString(chave, valor).apply()
    }

    fun getString(chave: String): String{
        return sharedPreferences.getString(chave, "") ?: ""
    }

}