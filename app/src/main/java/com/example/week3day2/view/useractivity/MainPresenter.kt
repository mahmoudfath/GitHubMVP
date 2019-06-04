package com.example.week3day2.view.useractivity

import android.util.Log
import androidx.lifecycle.Transformations
import com.example.week3day2.data.repository.Repository

class MainPresenter(private val view: MainContract.View, private val repository: Repository) : MainContract.Presenter {

    override fun loadUseer() = Transformations.map(repository.getUser("https://api.github.com/users/mahmoudfath")) {
        Log.d("MADFS", it.toString())
        return@map it
    }
}