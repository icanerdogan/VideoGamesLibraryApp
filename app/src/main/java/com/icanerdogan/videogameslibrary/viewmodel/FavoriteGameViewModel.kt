package com.icanerdogan.videogameslibrary.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.icanerdogan.videogameslibrary.model.DetailGame
import com.icanerdogan.videogameslibrary.model.FavoriteGame
import com.icanerdogan.videogameslibrary.service.APIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FavoriteGameViewModel : ViewModel() {
    private val apiService = APIService()
    private val disposable = CompositeDisposable()

    val favoriteGameLiveData = MutableLiveData<FavoriteGame>()

    fun getFavoriteDataFromAPI(favoriteGameID : Int){
        disposable.add(apiService.addFavoriteWithID(favoriteGameID)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<FavoriteGame>(){
                override fun onSuccess(t: FavoriteGame) {
                    favoriteGameLiveData.postValue(t)
                }
                override fun onError(e: Throwable) {
                    println("Wrong : ${e}")
                }
            })
        )
    }

}
