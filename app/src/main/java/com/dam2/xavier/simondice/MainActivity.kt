package com.dam2.xavier.simondice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addToSec(sec : MutableList<Int>)  {
        val numb= Random.nextInt(4) + 1
        sec.add(numb)
    }

    fun checkSec(sec : MutableList<Int>, secUsr : MutableList<Int>) : Boolean {
        return sec == secUsr
    }
}