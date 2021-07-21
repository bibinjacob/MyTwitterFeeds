package com.bibin.twitte.base.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val responseSuccessLiveData = MutableLiveData<Response>()
    val responseStatusLiveData = MutableLiveData<Status>()
    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun getResponseSuccessLiveData(): LiveData<Response> {
        return responseSuccessLiveData
    }

    private fun setStatusError() = responseStatusLiveData.postValue(Status.Failure)

    private fun setStatusSuccess() = responseStatusLiveData.postValue(Status.Successful)

    fun handleApiResponse(response: Response) {
        if (response.success) {
            setStatusSuccess()
        } else {
            setStatusError()
        }
        responseSuccessLiveData.postValue(response)
    }

    private fun clearDisposables() = compositeDisposable.clear()

    override fun onCleared() {
        super.onCleared()
        clearDisposables()
    }
}