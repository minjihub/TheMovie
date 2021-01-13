package com.example.themovie.service

import com.example.themovie.model.MovieData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApi {
    private val movieService: MovieService
    private val BASE_URL = "https://api.themoviedb.org/3/"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        movieService = retrofit.create(MovieService::class.java)
    }

    fun getMovieListRetrofit(param: Map<String, String>): Call<MovieData>{
        return movieService.getTop(param)
    }
}