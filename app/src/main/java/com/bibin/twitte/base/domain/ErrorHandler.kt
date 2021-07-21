package com.bibin.twitte.base.domain

import com.bibin.twitte.base.domain.entity.ResponseEntity


/**
 * Common interface for handling Errors.
 * */
interface ErrorHandler {

    fun <T> getError(throwable: Throwable): ResponseEntity<T>

    /* status code is 400 for validation error*/
    fun <T> checkForValidationError(responseEntity: ResponseEntity<T>): ResponseEntity<T>

    fun getServerMessage(throwable: Throwable): ResponseEntity<Nothing>
}