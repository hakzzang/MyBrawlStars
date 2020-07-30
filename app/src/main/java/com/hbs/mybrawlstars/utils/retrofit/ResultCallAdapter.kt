package com.hbs.mybrawlstars.utils.retrofit

import com.hbs.mybrawlstars.domain.remote.api.ApiResult
import retrofit2.Call
import retrofit2.CallAdapter

/*
* link : https://mlog.club/article/798924
* */
class ResultAdapter<T:Any>(
    private val clazz: Class<T>
): CallAdapter<T, Call<ApiResult<T>>> {
    override fun responseType() = clazz
    override fun adapt(call: Call<T>): Call<ApiResult<T>> = ResultCall(call)
}