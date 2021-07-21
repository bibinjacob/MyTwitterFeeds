package com.bibin.twitte.base.data


import com.bibin.twitte.base.data.network.NetworkException
import com.bibin.twitte.base.data.network.entity.ErrorResponseData
import com.bibin.twitte.base.data.network.entity.toResponseEntity
import com.bibin.twitte.base.domain.ErrorHandler
import com.bibin.twitte.base.domain.entity.ErrorEntity
import com.bibin.twitte.base.domain.entity.ResponseEntity
import okio.IOException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import javax.inject.Inject

class GeneralErrorHandlerImpl @Inject constructor() :
    ErrorHandler {


    override fun <T> getError(throwable: Throwable): ResponseEntity<T> {
        val errorEntity = getErrorEntity(throwable)
        return if (throwable is NetworkException) {
            throwable.toResponseEntity(errorEntity)
        } else
            ResponseEntity(errorEntity = errorEntity)
    }

    private fun getErrorEntity(throwable: Throwable): ErrorEntity {
        return when (throwable) {
            is SocketTimeoutException -> ErrorEntity.ApiError.TimeOutError
            is IOException -> ErrorEntity.ApiError.NoInternet
            is NetworkException -> validateResponseCode(
                throwable.throwable as HttpException,
                ErrorEntity.ApiError.UnknownNetworkError
            )
            is HttpException -> validateResponseCode(
                throwable,
                ErrorEntity.ApiError.UnknownHttpError
            )
            else -> ErrorEntity.ApiError.Unknown
        }
    }

    private fun validateResponseCode(
        throwable: HttpException,
        defaultErrorEntity: ErrorEntity = ErrorEntity.ApiError.Unknown
    ): ErrorEntity {
        return when (throwable.response()?.code()) {

            //Validation Error
            400, 410 -> ErrorEntity.ApiError.ValidationError

            //all other errors will be treated as unknown error
            else -> defaultErrorEntity
        }
    }

    /* handle api errors when http status 200*/
    override fun <T> checkForValidationError(responseEntity: ResponseEntity<T>): ResponseEntity<T> {
        if (responseEntity.statusCode != 200) {
            ErrorEntity.ApiError.UnknownNetworkError

        }
        return responseEntity
    }

    override fun getServerMessage(throwable: Throwable): ResponseEntity<Nothing> {
        val errorEntity = getErrorEntity(throwable)
        return if (throwable is NetworkException) {
            if (throwable.error is ErrorResponseData) {
                ResponseEntity(
                    statusCode = throwable.error.statusCode ?: 0,
                    errorEntity = errorEntity
                )
            } else throwable.toResponseEntity(errorEntity)
        } else ResponseEntity(
            errorEntity = errorEntity
        )
    }
}
