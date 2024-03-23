package com.example.koinguide

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//same as module in dagger(we need to provide our dependency
val appModule= module {

    //same as singleton in dagger
    single {
        //providing how to provide myApi instance
        Retrofit.Builder().baseUrl("http://google.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }
    //MainRepository is type of provide func bec we want to inject the interface not its implementation
    single<MainRepository> {
        //the get func will automatically take its dependency which we defined earlier in this case myApi is dependency
        MainRepositoryImpl(get())
    }
    //for providing dependency to viewmodel
    viewModel{
        MainViewModel(get())
    }

/*  it is for multiple instances not singleton
    factory {
        //the get func will automatically take its dependency which we defined earlier in this case myApi is dependency
        MainRepositoryImpl(get())
    }*/
}