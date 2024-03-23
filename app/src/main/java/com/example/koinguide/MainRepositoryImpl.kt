package com.example.koinguide

class MainRepositoryImpl(
    private val api: MyApi
):MainRepository {
    override fun doNetworkCall() {
        api.callApi()
    }
}