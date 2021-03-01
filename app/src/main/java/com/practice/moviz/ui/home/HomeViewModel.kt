package com.practice.moviz.ui.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.practice.moviz.R
import com.practice.moviz.data.model.Movie
import com.practice.moviz.data.model.Story
import com.practice.moviz.repositories.MoviesRepository
import javax.inject.Inject

class HomeViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    val moviesRepository: MoviesRepository
) : ViewModel()  {

    var movies: MutableLiveData<MutableList<Movie>> = MutableLiveData(mutableListOf())


    fun storiesList(): List<Story> {
        return listOf(
            Story(
                icon = R.drawable.story,
                title = "hatim E."
            ),
            Story(
                icon = R.drawable.story2,
                title = "enezari h."
            ),
            Story(
                icon = R.drawable.story,
                title = "hatim E."
            ),
            Story(
                icon = R.drawable.story2,
                title = "enezari h."
            ),
            Story(
                icon = R.drawable.story,
                title = "hatim E."
            ),
            Story(
                icon = R.drawable.story,
                title = "enezari h."
            )
        )
    }

    fun getMovies(){
        moviesRepository.getMovies(movies)
    }
}