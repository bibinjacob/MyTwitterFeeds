package com.bibin.twitte.twittemanager.presentation

import androidx.lifecycle.MutableLiveData
import com.bibin.twitte.base.domain.entity.mapToMyTwittes
import com.bibin.twitte.base.presentation.BaseViewModel
import com.bibin.twitte.base.presentation.Status
import com.bibin.twitte.base.presentation.entityToPresentation
import com.bibin.twitte.twittemanager.domain.GetMyTwitteUseCase
import com.bibin.twitte.twittemanager.presentation.entity.MyTwitte
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TwitterFeedListViewModel @Inject constructor(private val getMyTwitteUseCase: GetMyTwitteUseCase) :
    BaseViewModel() {
    private var disposable: Disposable? = null
    val twitterFeedsListObservable = MutableLiveData<List<MyTwitte>>()

    fun getMyTwitterFeeds() {
        if (responseStatusLiveData.value != Status.Loading) {
            disposable?.dispose()
            responseStatusLiveData.postValue(Status.Loading)
            disposable =
                getMyTwitteUseCase.getTwitterFeedList().subscribeOn(Schedulers.io())
                    .subscribe { responseEntity ->
                        if (responseEntity.statusCode == 200 && responseEntity.response != null) {
                            twitterFeedsListObservable.postValue(
                                responseEntity.response.mapToMyTwittes()
                            )
                        }
                        //Handle loading and api error
                        handleApiResponse(responseEntity.entityToPresentation())
                    }
            disposable?.let { addDisposable(it) }
        }
    }
}