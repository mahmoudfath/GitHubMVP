package com.example.week3day2.di

import com.example.week3day2.view.reposactivity.ReposActivity
import com.example.week3day2.view.useractivity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun injectMainPresenter(mainActivity: MainActivity)

    fun injectReposPresenter(reposActivity: ReposActivity)
}