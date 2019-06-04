package com.example.week3day2.view.reposactivity

import androidx.lifecycle.LiveData
import com.example.week3day2.model.Repos
import com.example.week3day2.model.User
import com.example.week3day2.view.BasePresenter
import com.example.week3day2.view.BaseView

interface ReposContract {
    interface Presenter : BasePresenter {
        fun loadRepos(): LiveData<List<Repos>>
    }
    interface View : BaseView<Presenter>
}