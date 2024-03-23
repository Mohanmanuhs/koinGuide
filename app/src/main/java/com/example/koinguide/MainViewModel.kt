package com.example.koinguide

import androidx.lifecycle.ViewModel


//dagger hilt is a compile time injected library , koin is runtime injected library

class MainViewModel(
    private val repository: MainRepository
):ViewModel() {
    fun doNetworkCall() {
        println("Something")
    }
}