package com.nasywa.kisahnabiapp.repo

import com.nasywa.kisahnabiapp.model.ResponseMain
import com.nasywa.kisahnabiapp.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.ScheduledFuture

class RepositoryMain {

    fun getData(responhandler: (List<ResponseMain>)-> Unit, errorHandler: (Throwable) -> Unit){
        ConfigNetwork.service().getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responhandler(it)
            }, {
                  errorHandler(it)
                })
    }
}