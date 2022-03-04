package com.icanerdogan.videogameslibrary.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.icanerdogan.videogameslibrary.model.DetailGame
import com.icanerdogan.videogameslibrary.service.APIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class DetailGameViewModel : ViewModel() {
    private val apiService = APIService()
    private val disposable = CompositeDisposable()
    //private var getClickedBasicGameID : Int = 0

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

}