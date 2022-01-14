package com.example.motivation.repository

import com.example.motivation.util.Constants
import kotlin.random.Random

class Mock {

    private val TODOS = Constants.TODOS
    private val POSITIVAS = Constants.POSITIVAS
    private val DIA = Constants.DIA

    private val mapFrases = mutableMapOf(
        POSITIVAS to mutableListOf(
            "Não sabendo que era impossível, foi lá e fez.",
            "Você não é derrotado quando perde, você é derrotado quando desiste!",
            "Quando está mais escuro, vemos mais estrelas!",
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            "Não pare quando estiver cansado, pare quando tiver terminado.",
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?"
        ),
        DIA to mutableListOf(
            "A melhor maneira de prever o futuro é inventá-lo.",
            "Você perde todas as chances que você não aproveita.",
            "Fracasso é o condimento que dá sabor ao sucesso.",
            "Enquanto não estivermos comprometidos, haverá hesitação!",
            "Se você não sabe onde quer ir, qualquer caminho serve.",
            "Se você acredita, faz toda a diferença.",
            "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!"
        )
    )

    var valoresFrases = mutableListOf<String>()

    private fun getCompleteList(){

        for(i in mapFrases){
            valoresFrases += i.value
        }
    }

    init {
        getCompleteList()
    }

    fun getFrase(filter: Int): String{

        val random: Int

        return if(filter != TODOS){

            val frasesFiltradas = mapFrases.getValue(filter)

            random = Random.nextInt(frasesFiltradas.size)

            frasesFiltradas[random]

        }else{

            random = Random.nextInt(valoresFrases.size)

            valoresFrases[random]
        }
    }

}