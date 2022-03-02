package com.icanerdogan.videogameslibrary.service

import com.icanerdogan.videogameslibrary.model.BaseGame
import io.reactivex.Single
import retrofit2.http.GET

interface GameService {

    @GET("api/games?key=a06731a1e7cf4b3f9a540e16cb512e25")
    fun getAllGames(): Single<BaseGame>

}