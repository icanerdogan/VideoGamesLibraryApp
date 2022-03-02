package com.icanerdogan.videogameslibrary.model

import com.google.gson.annotations.SerializedName

data class BaseGame(
    @SerializedName("results")
    val baseGameResults: ArrayList<BasicGame>
)
