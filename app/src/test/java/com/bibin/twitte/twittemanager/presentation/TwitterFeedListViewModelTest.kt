package com.bibin.twitte.twittemanager.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bibin.twitte.base.domain.entity.ErrorEntity
import com.bibin.twitte.base.domain.entity.ResponseEntity
import com.bibin.twitte.twittemanager.domain.GetMyTwitteUseCase
import com.bibin.twitte.twittemanager.domain.entity.MyTwitteEntity
import io.reactivex.Single
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TwitterFeedListViewModelTest : TestCase() {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var getMyTwitteUseCase: GetMyTwitteUseCase

    private lateinit var viewModel: TwitterFeedListViewModel

    @Before
    public override fun setUp() {
        viewModel = TwitterFeedListViewModel(getMyTwitteUseCase)
    }

    @Test
    fun ` verify FeedList size is not empty when getTwitterFeedList`() {
        //given
        val responseEntityMock =
            ResponseEntity(response = createTwitteFeedList())
        val myTwitteEntityMock = Single.just(responseEntityMock)
        `when`(getMyTwitteUseCase.getTwitterFeedList()).thenReturn(myTwitteEntityMock)

        //when
        viewModel.getMyTwitterFeeds()

        //then
        viewModel.twitterFeedsListObservable.observeForever {
            val listSize = viewModel.twitterFeedsListObservable.value
            assertTrue(listSize?.size ?: 0 > 0)
        }
    }

    @Test
    fun ` verify FeedList size is  empty when getTwitterFeedList`() {
        //given
        val responseEntityMock =
            ResponseEntity(response = createEmptyTwitteFeedList())
        val myTwitteEntityMock = Single.just(responseEntityMock)
        `when`(getMyTwitteUseCase.getTwitterFeedList()).thenReturn(myTwitteEntityMock)

        //when
        viewModel.getMyTwitterFeeds()

        //then
        viewModel.twitterFeedsListObservable.observeForever {
            val listSize = viewModel.twitterFeedsListObservable.value
            assertTrue(listSize?.size ?: 0 == 0)
        }
    }

    private fun createEmptyTwitteFeedList(): List<MyTwitteEntity> {
        return mutableListOf()
    }

    private fun createTwitteFeedList(): List<MyTwitteEntity> {

        val myTwittes: MutableList<MyTwitteEntity> = mutableListOf()
        myTwittes.add(
            MyTwitteEntity(
                createdAt = "11-12-2021",
                fullText = "My first twitte",
                id = 123456
            )
        )
        return myTwittes
    }
}