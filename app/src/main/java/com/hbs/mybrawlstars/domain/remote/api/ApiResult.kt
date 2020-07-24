package com.hbs.mybrawlstars.domain.remote.api


sealed class ApiResult<out T> {
    data class Success<out T : Any>(val data: T) : ApiResult<T>()
    data class Error(val exception: Exception) : ApiResult<Nothing>()
    object Loading: ApiResult<Nothing>()
}