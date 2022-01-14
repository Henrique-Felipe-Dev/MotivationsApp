package com.example.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.repository.Mock
import com.example.motivation.util.Constants

class MainActivity : AppCompatActivity() {

    private lateinit var securityPreferences: SecurityPreferences
    private lateinit var binding: ActivityMainBinding
    private var filter = Constants.TODOS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        securityPreferences = SecurityPreferences(this)

        val nome = securityPreferences.getString(Constants.NAME_KEY)

        binding.textNome.text = nome

        binding.buttonFrase.setOnClickListener {
            novaFrase(filter)
        }

        addFiltro(binding.imageTodos.id)

        binding.imageTodos.setOnClickListener {
            addFiltro(it.id)
        }

        binding.imagePositivas.setOnClickListener {
            addFiltro(it.id)
        }

        binding.imageDia.setOnClickListener {
            addFiltro(it.id)
        }

    }

    private fun addFiltro(id: Int) {

        DrawableCompat.setTint(
            binding.imageTodos.drawable, ContextCompat.getColor(this, R.color.colorAccent)
        )
        DrawableCompat.setTint(
            binding.imagePositivas.drawable, ContextCompat.getColor(this, R.color.colorAccent)
        )
        DrawableCompat.setTint(
            binding.imageDia.drawable, ContextCompat.getColor(this, R.color.colorAccent)
        )

        when (id){
            R.id.imageTodos -> {
                DrawableCompat.setTint(
                    binding.imageTodos.drawable, ContextCompat.getColor(this, R.color.white)
                )
                filter = Constants.TODOS
            }
            R.id.imagePositivas -> {
                DrawableCompat.setTint(
                    binding.imagePositivas.drawable, ContextCompat.getColor(this, R.color.white)
                )
                filter = Constants.POSITIVAS
            }
            R.id.imageDia -> {
                DrawableCompat.setTint(
                    binding.imageDia.drawable, ContextCompat.getColor(this, R.color.white)
                )
                filter = Constants.DIA
            }
        }
    }

    private fun novaFrase(filter: Int) {
        val mock = Mock()

        binding.editFrases.text = Editable.Factory.getInstance().newEditable(mock.getFrase(filter))

    }
}