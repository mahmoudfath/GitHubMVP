package com.example.week3day2.view.useractivity

import androidx.lifecycle.LiveData
import com.example.week3day2.data.repository.Repository
import com.example.week3day2.model.User
import com.example.week3day2.view.BasePresenter
import com.example.week3day2.view.BaseView

interface MainContract {
    interface Presenter : BasePresenter{
        fun loadUseer(): LiveData<User>
    }
    interface View : BaseView<Presenter>
}