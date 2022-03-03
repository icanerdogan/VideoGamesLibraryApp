package com.icanerdogan.videogameslibrary.service

import com.icanerdogan.videogameslibrary.model.BaseGame
import com.icanerdogan.videogameslibrary.model.DetailGame
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GameService {

    @GET("api/games?key=a06731a1e7cf4b3f9a540e16cb512e25")
    fun getAllGames(): Single<BaseGame>

    @GET("api/games/{ID}?key=a06731a1e7cf4b3f9a540e16cb512e25")
    fun getOneGamesWithID(@Path("ID") clickedGameID : Int) : Single<DetailGame>


}