package com.example.coroutinesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    var resultState by mutableStateOf("")
    private set

    var oneCount by mutableStateOf(false)
        private set

    /*
    Thread trabaja en el mismo contexto de la UI:


    fun bloqueoApp(){
        Thread.sleep(5000) //simular tiempo de espera
        resultState = "Respuesta del Servidor Web"
    }
    */


/*
    fun fetchData(){
        viewModelScope.launch {
            delay(5000)
            resultState = "Respuesta desde el Servidor Web"
        }
    }
 */
    var countTime by mutableStateOf(0)
    private set

   fun fetchData(){
       viewModelScope.launch {
           delay(5000)
           resultState = "Respuesta desde el servidor web"
       }

       val job = viewModelScope.launch {
           for (i in 1..5) {
               delay(1000)
               countTime = i
           }

           oneCount  = true

       }

       if (oneCount){
           job.cancel()
       }

   }
}