package com.icanerdogan.videogameslibrary.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class DetailGame(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val detailGameID : Int?,

    @ColumnInfo(name = "columnGameName")
    @SerializedName("name")
    val detailGameName : String?,

    @ColumnInfo(name = "columnGameURL")
    @SerializedName("background_image")
    val detailGameImageURL : String?,

    @SerializedName("released")
    val detailGameReleased : String?,
    @SerializedName("rating")
    val detailGameRating : Double?,
    @SerializedName("metacritic")
    val detailGameMetacritic : String?,
    @SerializedName("description")
    val detailGameDescription : String?,
)
