package com.icanerdogan.videogameslibrary.service

import com.icanerdogan.videogameslibrary.model.BaseGame
import com.icanerdogan.videogameslibrary.model.DetailGame
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GameService {

    @GET("api/games?key=fb4f637120f64b2fb8cb6de26ebfb942")
    fun getAllGames(): Single<BaseGame>

    @GET("api/games/{ID}?key=fb4f637120f64b2fb8cb6de26ebfb942")
    fun getOneGamesWithID(@Path("ID") clickedGameID : Int) : Single<DetailGame>

/*    @GET("api/games/{ID}?key=fb4f637120f64b2fb8cb6de26ebfb942")
    fun getFavoriteGamesWithID(@Path("ID") clickedGameID : Int) : Single<FavoriteGame>*/

}