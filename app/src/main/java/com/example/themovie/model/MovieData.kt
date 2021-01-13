package com.example.themovie.model

data class MovieData(var page: Int,
                     val results: ArrayList<MovieDetail>)