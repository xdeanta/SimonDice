package com.dam2.xavier.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sec: MutableList<Int> = mutableListOf<Int>()
        var user_sec: MutableList<Int> = mutableListOf<Int>()
        var finished  = false
        val button_red : Button = findViewById(R.id.rojo)
        val button_yellow : Button = findViewById(R.id.amarillo)
        val button_blue : Button = findViewById(R.id.azul)
        val button_green : Button = findViewById(R.id.verde)
        val button_start : Button = findViewById(R.id.start)
        val button_check : Button = findViewById(R.id.check)
        val toast = Toast.makeText(applicationContext,"Juego terminado", Toast.LENGTH_SHORT)
        val toast2 = Toast.makeText(applicationContext,"Inicio", Toast.LENGTH_SHORT)

        button_start.setOnClickListener{
            finished = false
            reset(sec,user_sec)
            addToSecu(sec)
            toast2.show()
            showSec(sec)
        }

        button_check.setOnClickListener{
            if(finished==false){
                if(checkSec(sec,user_sec)){
                    addToSecu(sec)
                    user_sec.clear()
                    showSec(sec)
                }else{
                    finished=true
                    toast.show()
                }
            }
        }
        button_red.setOnClickListener{
            addUserSec(user_sec,1)
        }
        button_green.setOnClickListener{
            addUserSec(user_sec,2)
        }
        button_yellow.setOnClickListener{
            addUserSec(user_sec,3)
        }
        button_blue.setOnClickListener{
            addUserSec(user_sec,4)
        }
        //showSec(sec)

    }

    fun addToSecu(sec : MutableList<Int>)  {
        val numb= Random.nextInt(4) + 1
        //val numb = 1;
        sec.add(numb)
    }

    fun checkSec(sec : MutableList<Int>, secUsr : MutableList<Int>) : Boolean {
        return sec == secUsr
    }

    fun reset(sec: MutableList<Int>, secUsr: MutableList<Int>){
        sec.clear()
        secUsr.clear()
    }

    fun addUserSec(secUsr: MutableList<Int>, color: Int){
        when(color){
            1 -> secUsr.add(1)
            2 -> secUsr.add(2)
            3 -> secUsr.add(3)
            else -> secUsr.add(4)
        }
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