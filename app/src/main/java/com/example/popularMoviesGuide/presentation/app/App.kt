package com.example.popularMoviesGuide.presentation.app

import android.app.Application
import com.example.popularMoviesGuide.presentation.di.AppComponent
import com.example.popularMoviesGuide.presentation.di.AppModule
import com.example.popularMoviesGuide.presentation.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

}