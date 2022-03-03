package com.icanerdogan.videogameslibrary.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.icanerdogan.videogameslibrary.model.BaseGame
import com.icanerdogan.videogameslibrary.model.BasicGame
import com.icanerdogan.videogameslibrary.service.APIService
import com.icanerdogan.videogameslibrary.service.GameService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class BasicGameViewModel : ViewModel() {
    private val apiService = APIService()
    private val disposable = CompositeDisposable()
    val games = MutableLiveData<BaseGame>()

    fun getAllGamesHomeScreen(){
        disposable.add(apiService.getAllGames()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<BaseGame>(){
                override fun onSuccess(t: BaseGame) {
                    games.postValue(t)
                }

                override fun onError(e: Throwable) {
                    println("Wrong : ${e.printStackTrace()}")
                }

            })
        )
    }
}