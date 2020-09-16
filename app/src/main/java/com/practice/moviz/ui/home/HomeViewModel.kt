package com.practice.moviz.ui.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.practice.moviz.R
import com.practice.moviz.data.model.Story

class HomeViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel()  {
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
}