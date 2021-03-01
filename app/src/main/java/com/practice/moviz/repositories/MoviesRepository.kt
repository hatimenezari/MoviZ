package com.practice.moviz.repositories

import androidx.lifecycle.MutableLiveData
import com.practice.moviz.data.model.Movie
import com.practice.moviz.data.model.Token
import com.practice.moviz.network.MoviesService
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MoviesRepository @Inject constructor(){

    @Inject lateinit var moviesService: MoviesService
    @Inject lateinit var token: Token

    fun getMovies(movies: MutableLiveData<MutableList<Movie>>) {
        moviesService.getMovies("all", 1,2020, token.apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if(it.isSuccessful && it.body() != null && !it.body()!!.search.isNullOrEmpty()) {
                    movies.value = it.body()!!.search.toMutableList()
                }
            },{
                //show error
            })
    }
}