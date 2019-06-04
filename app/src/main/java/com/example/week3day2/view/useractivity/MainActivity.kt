package com.example.week3day2.view.useractivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.week3day2.R
import com.example.week3day2.data.remote.GithubApiCall
import com.example.week3day2.data.repository.Repository
import com.example.week3day2.data.repository.RepositoryImpl
import com.example.week3day2.di.AppModule
import com.example.week3day2.di.DaggerAppComponent
import com.example.week3day2.model.Repos
import com.example.week3day2.model.User
import com.example.week3day2.view.reposactivity.ReposActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {//

    @Inject
    lateinit var presenter: MainContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponent.builder().appModule(AppModule(this)).build().injectMainPresenter(this)

        presenter.loadUseer().observe(this, Observer {
            Log.d("MADFS", it.toString())
            tvUserOne.text = it.htmlUrl
            tvUserTwo.text = it.login
            tvUserThree.text = it.location
        })

        btMain.setOnClickListener {

            startActivity(Intent(this, ReposActivity::class.java))
        }
    }


}
