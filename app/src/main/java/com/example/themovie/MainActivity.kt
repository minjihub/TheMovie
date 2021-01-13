package com.example.themovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovie.service.MovieManager
import com.example.themovie.service.RestApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MovieManager(RestApi()).getMovieList {
            val adapter = MovieAdapter(it)
            val layoutManager = LinearLayoutManager(this)

            movie_list.adapter = adapter
            movie_list.layoutManager = layoutManager
        }
    }
}