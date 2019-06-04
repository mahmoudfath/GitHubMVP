package com.example.week3day2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week3day2.R
import com.example.week3day2.model.Repos
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_repos.*

class ReposAdapte(private val reposlist: List<Repos>):RecyclerView.Adapter<RecyclerView.ViewHolder> (){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_repos,parent,false)
        return ReposViewHolder(itemView)
    }

    override fun getItemCount() = reposlist.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pos = reposlist[position]
        (holder as ReposViewHolder).bind(pos)

    }

    class ReposViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(repos: Repos) {
            tvReposName.text = repos.name
            tvReposId.text = repos.id.toString()
            tvReposStar.text = repos.language
        }
    }
}