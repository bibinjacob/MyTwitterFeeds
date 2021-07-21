package com.bibin.twitte.base.data.network.entity

import com.bibin.twitte.base.data.network.NetworkException
import com.bibin.twitte.base.domain.entity.ErrorEntity
import com.bibin.twitte.base.domain.entity.Errors
import com.bibin.twitte.base.domain.entity.ResponseEntity
import com.bibin.twitte.twittemanager.data.entity.MyTwitteData
import com.bibin.twitte.twittemanager.domain.entity.MyTwitteEntity
import retrofit2.HttpException

/**********Error Response Mapper Extension methods**************/

internal fun <T> NetworkException.toResponseEntity(errorEntity: ErrorEntity): ResponseEntity<T> {

    return when (this.error) {
        is ErrorResponseData -> {
            val code = if (this.throwable is HttpException) {
                throwable.code()
            } else null
            this.error.responseDataToEntity(errorEntity, code)
        }

        else -> ResponseEntity(errorEntity = errorEntity)
    }
}

internal fun <T> ErrorResponseData.responseDataToEntity(
    errorEntity: ErrorEntity,
    code: Int?
): ResponseEntity<T> {
    return ResponseEntity(
        errors = this.errors?.mapToErrorEntity(),
        statusCode = code ?: 0,
        errorEntity = errorEntity
    )
}

fun List<Error>.mapToErrorEntity(): List<Errors> {

    val errors: MutableList<Errors> = mutableListOf()
    this.map {
        errors.add(Errors(code = it.code, message = it.message))
    }
    return errors
}

fun List<MyTwitteData>.mapToTwitteResponseEntity(): ResponseEntity<MyTwitteEntity> {
    return ResponseEntity(
        response = this.mapToResponseEntity()
    )
}

fun List<MyTwitteData>.mapToResponseEntity(): List<MyTwitteEntity> {
    val twitteList: MutableList<MyTwitteEntity> = mutableListOf()

    this.map {
        twitteList.add(it.mapToEntityData())
    }
    return twitteList
}

private fun MyTwitteData.mapToEntityData(): MyTwitteEntity {
    return MyTwitteEntity(
        createdAt = this.createdAt ?: "",
        fullText = this.fullText ?: "",
        id = this.id ?: 0
    )
}