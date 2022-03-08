package com.icanerdogan.videogameslibrary.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.icanerdogan.videogameslibrary.model.DetailGame
import com.icanerdogan.videogameslibrary.service.APIService
import com.icanerdogan.videogameslibrary.service.FavoriteGameDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DetailGameViewModel(application: Application) : BaseViewModel(application){
    private val apiService = APIService()
    private val disposable = CompositeDisposable()

    val detailGameLiveData = MutableLiveData<DetailGame>()

    fun getDetailDataFromAPI(detailGameID : Int){
        disposable.add(apiService.getOneGamesWithID(detailGameID)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<DetailGame>(){
                override fun onSuccess(t: DetailGame) {
                   return detailGameLiveData.postValue(t)
                }
                override fun onError(e: Throwable) {
                    println("Wrong : ${e.printStackTrace()}")
                }

            })
        )
    }

    fun storeInSQLLite(detailGame: DetailGame){
        launch {
            val dao = FavoriteGameDatabase(getApplication()).favoriteGameDao()
            dao.insertFavoriteGame(detailGame)

        }
    }

}