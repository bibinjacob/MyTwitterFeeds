package com.bibin.twitte.twittemanager.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bibin.twitte.base.data.GeneralErrorHandlerImpl
import com.bibin.twitte.base.domain.entity.ErrorEntity
import com.bibin.twitte.base.domain.entity.ResponseEntity
import com.bibin.twitte.twittemanager.data.MyTwitteRepository
import com.bibin.twitte.twittemanager.domain.entity.MyTwitteEntity
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetMyTwitteUseCaseTest : TestCase() {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var errorHandlerImpl: GeneralErrorHandlerImpl

    @Mock
    lateinit var repository: MyTwitteRepository

    private lateinit var getMyTwitteUseCase: GetMyTwitteUseCase

    @Before
    public override fun setUp() {
        getMyTwitteUseCase = GetMyTwitteUseCase(repository, errorHandlerImpl)
    }

    @Test
    fun getTwitterFeedList() {
    }

    @Test
    fun ` verify getTwitterFeedList api call is success`() {
        //given
        val responseEntityMock =
            ResponseEntity(
                response = createEmptyTwitteFeedList()
            )
        val myTwitteEntityMock = Single.just(responseEntityMock)
        val testObserver = TestObserver<ResponseEntity<MyTwitteEntity>>()

        Mockito.`when`(repository.getTwitterFeedList()).thenReturn(myTwitteEntityMock)

        //when
        repository.getTwitterFeedList()

        //then
        myTwitteEntityMock.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
    }

    private fun createEmptyTwitteFeedList(): List<MyTwitteEntity> {
        return mutableListOf()
    }
}