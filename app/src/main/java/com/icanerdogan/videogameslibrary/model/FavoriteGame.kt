package com.icanerdogan.videogameslibrary.model

import com.google.gson.annotations.SerializedName

data class FavoriteGame(
    @SerializedName("id")
    val favoriteGameID : Int?,
    @SerializedName("name")
    val favoriteGameName : String?,
    @SerializedName("released")
    val favoriteGameReleased : String?,
    @SerializedName("rating")
    val favoriteGameRating : Double?,
    @SerializedName("background_image")
    val favoriteGameImageURL : String?,
)
