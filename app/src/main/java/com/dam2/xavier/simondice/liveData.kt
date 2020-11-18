package com.dam2.xavier.simondice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class liveData : ViewModel(){
    val secuenciaJ = MutableLiveData<MutableList<Int>>()
    val secuenciaU = MutableLiveData<MutableList<Int>>()
    val gameState = MutableLiveData<Boolean>()

    init{
        secuenciaU.value = mutableListOf<Int>()
        secuenciaJ.value= mutableListOf<Int>()
        gameState.value= false
    }

    fun init_game() : MutableList<Int>{
        gameState.value=false;
        reset()
        addToSecu()
        return secuenciaJ.value!!
    }

    private fun addToSecu()  {
        val numb= Random.nextInt(4) + 1
        //val numb = 1;
        secuenciaJ.value?.add(numb)
    }

    fun checkSec() : Boolean {
        var ret=false
        if(secuenciaJ.value == secuenciaU.value && gameState.value == false){
            addToSecu()
            secuenciaU.value?.clear()
            ret=true;
        }else{
            gameState.value=true;
        }
        return ret;
    }

    private fun reset(){
        secuenciaJ.value?.clear()
        secuenciaU.value?.clear()
    }

    fun addUserSec(color: Int){
        when(color){
            1 -> secuenciaU.value?.add(1)
            2 -> secuenciaU.value?.add(2)
            3 -> secuenciaU.value?.add(3)
            else -> secuenciaU.value?.add(4)
        }
    }

    fun getSec(): MutableList<Int>{
        return secuenciaJ.value!!
    }
}