package com.example.themovie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.themovie.model.MovieDetail
import kotlinx.android.synthetic.main.movie_detail_view.*

class MovieDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail_view)

        val detailData = intent.getParcelableExtra<MovieDetail>("data")

        detailData?.let {
            movie_title.text = it.title
            average.text = "${it.vote_average} 점"
            vote.text = "${it.vote_count} 투표"
            summary.text = it.overview

            Glide.with(this)
                    .load("https://image.tmdb.org/t/p/w500/${it.poster_path}")
                    .into(image)
        }
    }
}