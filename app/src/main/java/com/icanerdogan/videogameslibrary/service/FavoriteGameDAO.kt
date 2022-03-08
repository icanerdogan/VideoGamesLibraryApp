package com.icanerdogan.videogameslibrary.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.icanerdogan.videogameslibrary.model.DetailGame

@Dao
interface FavoriteGameDAO {
    @Insert
    suspend fun insertFavoriteGame(vararg detailGame: DetailGame) : Int

    /*@Query("SELECT * FROM detailgame")
    suspend fun getAllFavoriteGame() : List<DetailGame>*/


}