package com.example.week3day2.view.reposactivity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week3day2.R
import com.example.week3day2.adapters.ReposAdapte
import com.example.week3day2.di.AppModule
import com.example.week3day2.di.DaggerAppComponent

import kotlinx.android.synthetic.main.activity_repos.*
import javax.inject.Inject

class ReposActivity : AppCompatActivity(),ReposContract.View {
    @Inject
    lateinit var presenter: ReposContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos)
        DaggerAppComponent.builder().appModule(AppModule(this@ReposActivity)).build().injectReposPresenter(this)

        presenter.loadRepos().observe(this, Observer {
            val myAdapter = ReposAdapte(it)
            recyclerView.apply {
                adapter = myAdapter
                layoutManager = LinearLayoutManager(this@ReposActivity)
            }
        })

    }

}
