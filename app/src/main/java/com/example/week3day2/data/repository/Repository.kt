package com.example.week3day2.data.repository

import androidx.lifecycle.LiveData
import com.example.week3day2.model.Repos
import com.example.week3day2.model.User

interface Repository {
    fun getUser(user:String):LiveData<User>

    fun getRepos(repos:String):LiveData<List<Repos>>

}