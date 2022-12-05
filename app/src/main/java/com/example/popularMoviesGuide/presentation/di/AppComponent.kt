package com.example.popularMoviesGuide.presentation.di

import com.example.popularMoviesGuide.presentation.view.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}