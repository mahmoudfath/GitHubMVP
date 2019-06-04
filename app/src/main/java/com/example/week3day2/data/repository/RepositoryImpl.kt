package com.example.week3day2.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.week3day2.data.remote.GithubApiCall
import com.example.week3day2.model.Repos
import com.example.week3day2.model.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RepositoryImpl(private val githubApiCall: GithubApiCall,private val liveData:MutableLiveData<User>,private val repLiveData: MutableLiveData<List<Repos>>):Repository {
    override fun getUser(user: String): LiveData<User> {
        GlobalScope.launch {
            val res = githubApiCall.getuser(user).await()
            liveData.postValue(res)

        }
        return liveData
    }

    override fun getRepos(repos: String): LiveData<List<Repos>> {
        GlobalScope.launch {
            try {
                val res = githubApiCall.getrepos(repos).await()
                repLiveData.postValue(res)
            } catch(e: Exception) {
                e.printStackTrace()
            }

        }
        return repLiveData
    }
}