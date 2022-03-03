package com.icanerdogan.videogameslibrary.model

import com.google.gson.annotations.SerializedName

data class DetailGame(
    @SerializedName("id")
    val detailGameID : Int?,
    @SerializedName("name")
    val detailGameName : String?,
    @SerializedName("released")
    val detailGameReleased : String?,
    @SerializedName("metacritic")
    val detailGameMetacritic : String?,
    @SerializedName("background_image")
    val detailGameImageURL : String?,
    @SerializedName("description")
    val detailGameDescription : String?
)
