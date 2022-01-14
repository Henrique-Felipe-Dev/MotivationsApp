package com.example.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.motivation.databinding.ActivitySplashBinding
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.util.Constants

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var securityPreferences: SecurityPreferences
    private lateinit var intentMainActivity: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intentMainActivity = Intent(this, MainActivity::class.java)

        securityPreferences = SecurityPreferences(this)

        if(supportActionBar != null){
            supportActionBar!!.hide()
        }

        binding.buttonSalvar.setOnClickListener {
            handleSave()
        }

        verificarNome()

    }

    private fun verificarNome(){
        val nome = securityPreferences.getString(Constants.NAME_KEY)

        if(nome != ""){
            startActivity(intentMainActivity)
            finish()
        }
    }

    private fun handleSave() {

        val nome = binding.editNome.text.toString()

        if(nome != ""){
            securityPreferences.storeString(Constants.NAME_KEY, nome)
            startActivity(intentMainActivity)
            finish()
        }else{
            Toast.makeText(this, "Por favor, informe seu nome!", Toast.LENGTH_SHORT).show()
        }
    }
}