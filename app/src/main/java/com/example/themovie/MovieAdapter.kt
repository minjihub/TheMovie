package com.example.themovie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themovie.model.MovieDetail
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(private val list: ArrayList<MovieDetail>) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class MovieHolder(private val view: View) : RecyclerView.ViewHolder(view){
        fun bind(detail : MovieDetail){
            view.title.text = detail.title
            view.date.text = detail.release_date
            view.summary.text = detail.overview

            Glide.with(view)
                .load("https://image.tmdb.org/t/p/w500/${detail.poster_path}")
                .into(view.image)


            view.setOnClickListener {
                val intent = Intent(view.context, MovieDetailActivity::class.java)
                intent.putExtra("data", detail)
                view.context.startActivity(intent)
            }
        }
    }
}