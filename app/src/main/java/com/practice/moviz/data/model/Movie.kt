package com.practice.moviz.data.model

import com.google.gson.annotations.SerializedName


class Movie constructor(
    @SerializedName("Title") val title: String
)