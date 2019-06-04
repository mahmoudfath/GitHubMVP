package com.example.week3day2.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.example.week3day2.data.remote.GithubApiCall
import com.example.week3day2.data.repository.Repository
import com.example.week3day2.data.repository.RepositoryImpl
import com.example.week3day2.model.Repos
import com.example.week3day2.model.User
import com.example.week3day2.view.reposactivity.ReposContract
import com.example.week3day2.view.reposactivity.ReposPresenter
import com.example.week3day2.view.useractivity.MainActivity
import com.example.week3day2.view.useractivity.MainContract
import com.example.week3day2.view.useractivity.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val activity: AppCompatActivity) {
    @Provides
    @Singleton
    fun providesGithubApiCall()= GithubApiCall.create()

    @Provides
    @Singleton
    fun provideRepository(githubApiCall: GithubApiCall, liveData: MutableLiveData<User>,liveRepos: MutableLiveData<List<Repos>>):Repository =
            RepositoryImpl(githubApiCall,liveData,liveRepos)

    @Provides
    fun provideUserliveData()= MutableLiveData<User>()

    @Provides
    fun provideReposliveData()= MutableLiveData<List<Repos>>()

    @Provides
    fun providMainPresenter(repository: Repository):MainContract.Presenter= MainPresenter(activity as MainContract.View,repository)

    @Provides
    fun provideReposPresenter(repository: Repository):ReposContract.Presenter=ReposPresenter(activity as ReposContract.View,repository)



}