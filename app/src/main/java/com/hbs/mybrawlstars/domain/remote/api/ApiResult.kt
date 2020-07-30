package com.hbs.mybrawlstars.domain.remote.api

sealed class ApiResult<out T> {
    data class Success<out T : Any>(val status: HttpStatus, val data:T) : ApiResult<T>()
    data class Error(val status: HttpStatus, val data:String) : ApiResult<Nothing>()
    data class Fail(val throwable: Throwable) : ApiResult<Nothing>()

    data class InternalError(val status: HttpStatus) : ApiResult<Nothing>()
    object Loading: ApiResult<Nothing>()
}