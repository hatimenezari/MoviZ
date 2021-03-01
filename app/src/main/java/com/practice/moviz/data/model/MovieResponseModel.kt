package com.practice.moviz.data.model

import com.google.gson.annotations.SerializedName

class MovieResponseModel constructor(
    @SerializedName("Search") val search: List<Movie>
)