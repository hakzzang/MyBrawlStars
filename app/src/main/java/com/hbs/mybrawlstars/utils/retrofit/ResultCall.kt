package com.hbs.mybrawlstars.utils.retrofit

import com.hbs.mybrawlstars.domain.remote.api.ApiResult
import com.hbs.mybrawlstars.domain.remote.api.convertCodeToStatus
import com.hbs.mybrawlstars.domain.remote.api.convertStatusToLogic
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
* link : https://mlog.club/article/798924
* */
class ResultCall<T : Any>(proxy: Call<T>) : CallDelegate<T, ApiResult<T>>(proxy) {
    override fun enqueueImpl(callback: Callback<ApiResult<T>>) =
        proxy.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val code = response.code()
                val status = code.convertCodeToStatus()
                status.convertStatusToLogic({
                    val body = response.body()?:return@convertStatusToLogic
                    val apiResult = ApiResult.Success(code.convertCodeToStatus(), body)
                    callback.onResponse(this@ResultCall, Response.success(code, apiResult))
                },{
                    when {
                        response.errorBody() != null -> {
                            val errorBody = response.errorBody()?:return@convertStatusToLogic
                            callback.onResponse(this@ResultCall, Response.success(ApiResult.Error(code.convertCodeToStatus(), errorBody.string())))
                        }
                        else -> {
                            callback.onResponse(this@ResultCall, Response.success(code, ApiResult.InternalError(code.convertCodeToStatus())))
                        }
                    }
                },{
                    callback.onResponse(this@ResultCall, Response.success(ApiResult.InternalError(code.convertCodeToStatus())))
                })
            }

            override fun onFailure(call: Call<T>, throwable: Throwable) {
                val fail = ApiResult.Fail(throwable)
                callback.onResponse(this@ResultCall, Response.success(fail))
            }
        })

    override fun cloneImpl() = ResultCall(proxy.clone())
    override fun timeout(): Timeout = proxy.timeout()
}