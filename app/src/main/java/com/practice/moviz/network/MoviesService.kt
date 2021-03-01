package com.practice.moviz.network

import com.practice.moviz.data.model.Movie
import com.practice.moviz.data.model.MovieResponseModel
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET("/")
    fun getMovies(
        @Query("s") s: String?,
        @Query("page") page: Int,
        @Query("y") year: Int,
        @Query("apiKey") apiKey: String
    ): Observable<Response<MovieResponseModel>>

}