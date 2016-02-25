package com.github.cirorizzo.kshows.presenter

import com.github.cirorizzo.kshows.model.cats.Cats
import com.github.cirorizzo.kshows.network.CatAPINetwork
import com.github.cirorizzo.kshows.view.ImagesAdapter
import com.github.cirorizzo.kshows.view.MainActivityInterface
import rx.Observable


class MasterPresenterImpl : MasterPresenter {
    lateinit private var mainActivityInterface: MainActivityInterface
    lateinit private var imagesAdapter: ImagesAdapter

    override fun connect(mainActivityInterface: MainActivityInterface, imagesAdapter: ImagesAdapter) {
        this.mainActivityInterface = mainActivityInterface
        this.imagesAdapter = imagesAdapter
    }


    override fun getMasterRequest() {
        val catAPINetwork = CatAPINetwork()
        catAPINetwork.getExec()
        imagesAdapter.setObservable(getObservableMasterRequest())
    }


    override fun getObservableMasterRequest(): Observable<Cats> {
        return CatAPINetwork().getExec()
    }


}