package com.example.week3day2.view.reposactivity

import androidx.lifecycle.LiveData
import com.example.week3day2.data.repository.Repository
import com.example.week3day2.model.Repos

class ReposPresenter(private val view: ReposContract.View,private val repository: Repository):ReposContract.Presenter {

    override fun loadRepos()= repository.getRepos("mahmoudfath")

}