package com.icanerdogan.videogameslibrary.model

import com.google.gson.annotations.SerializedName

data class BasicGame(
    @SerializedName("id")
    val basicGameID : Int?,
    @SerializedName("name")
    val basicGameName : String?,
    @SerializedName("rating")
    val basicGameRating : Double?,
    @SerializedName("released")
    val basicGameReleased : String?,
    @SerializedName("background_image")
    val basicGameImageURL : String?
)
