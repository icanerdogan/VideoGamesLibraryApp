package com.icanerdogan.videogameslibrary.service

import com.icanerdogan.videogameslibrary.model.BaseGame
import com.icanerdogan.videogameslibrary.model.DetailGame
import com.icanerdogan.videogameslibrary.model.FavoriteGame
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIService {
    private val  BASE_URL = "https://api.rawg.io/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(GameService::class.java)

    fun getAllGames() : Single<BaseGame>{
        return api.getAllGames()
    }

    fun getOneGamesWithID(clickedGameID : Int) : Single<DetailGame>{
        return api.getOneGamesWithID(clickedGameID)
    }

    fun addFavoriteWithID(clickedGameID : Int) : Single<FavoriteGame>{
        return api.getFavoriteGamesWithID(clickedGameID)
    }
}