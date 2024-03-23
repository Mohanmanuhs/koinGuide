package com.example.koinguide

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

// add android:name=".MyApplication" in manifest file
class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        //for starting koin when app starts
        startKoin{
            androidLogger(Level.ERROR)
            //for providing context
            androidContext(this@MyApplication)
            //all defined modules
            modules(appModule, activityModule)
        }
    }

}