package com.example.themovie.service

import android.util.Log
import com.example.themovie.model.MovieData
import com.example.themovie.model.MovieDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieManager(private val api: RestApi) {

    fun getMovieList(success:((ArrayList<MovieDetail>) -> Unit)){
        val param = mapOf(
            "page" to "1",
            "api_key" to "발급한 API KEY 입력",
            "sort_by" to "popularity.desc",
            "language" to "ko"
        )

        val call = api.getMovieListRetrofit(param)
        call.enqueue(object : Callback<MovieData>{
            override fun onFailure(call: Call<MovieData>, t: Throwable) {
                Log.e("log_fail", t.toString())
            }

            override fun onResponse(call: Call<MovieData>, response: Response<MovieData>) {
                Log.e("log_result", response.body().toString())

                val result = response.body()
                result?.let {
                    success(it.results)
                }
            }
        })
    }
}