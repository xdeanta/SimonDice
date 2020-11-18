package com.dam2.xavier.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

import kotlin.random.Random
import kotlinx.coroutines.*

import androidx.lifecycle.Observer
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sec: MutableList<Int>
        val button_red : Button = findViewById(R.id.rojo)
        val button_yellow : Button = findViewById(R.id.amarillo)
        val button_blue : Button = findViewById(R.id.azul)
        val button_green : Button = findViewById(R.id.verde)
        val button_start : Button = findViewById(R.id.start)
        val button_check : Button = findViewById(R.id.check)
        val toast = Toast.makeText(applicationContext,"Juego terminado", Toast.LENGTH_SHORT)
        val toast2 = Toast.makeText(applicationContext,"Inicio", Toast.LENGTH_SHORT)

        val ModeloJuego by viewModels<liveData>()

        button_start.setOnClickListener{
            toast2.show()
            sec=ModeloJuego.init_game()
            showSec(sec)
        }

        button_check.setOnClickListener{
            if(ModeloJuego.checkSec()){
                sec=ModeloJuego.getSec()
                showSec(sec)
            }else{
                toast.show()
            }
        }
        button_red.setOnClickListener{
            ModeloJuego.addUserSec(1)
        }
        button_green.setOnClickListener{
            ModeloJuego.addUserSec(2)
        }
        button_yellow.setOnClickListener{
            ModeloJuego.addUserSec(3)
        }
        button_blue.setOnClickListener{
            ModeloJuego.addUserSec(4)
        }
        //showSec(sec)

    }

    fun showSec(sec: MutableList<Int>){
        val button_red : Button = findViewById(R.id.rojo)
        val button_yellow : Button = findViewById(R.id.amarillo)
        val button_blue : Button = findViewById(R.id.azul)
        val button_green : Button = findViewById(R.id.verde)

        CoroutineScope(Dispatchers.Main).launch{
            for (color in sec){
                when(color){
                1 -> {
                    button_red.setPressed(true)
                    delay(1000)
                    button_red.setPressed(false)
                }
                2 -> {
                    button_green.setPressed(true)
                    delay(1000)
                    button_green.setPressed(false)
                }
                3 -> {
                    button_yellow.setPressed(true)
                    delay(1000)
                    button_yellow.setPressed(false)
                }
                4 -> {
                    button_blue.setPressed(true)
                    delay(1000)
                    button_blue.setPressed(false)
                }
                }
            }

        }
    }
}