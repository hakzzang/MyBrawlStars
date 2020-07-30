package com.hbs.mybrawlstars.utils.retrofit

import com.hbs.mybrawlstars.domain.remote.api.ApiResult
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/*
* link : https://mlog.club/article/798924
* */
class ErrorHandlingCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ):ResultAdapter<out Any>? {
        return when (getRawType(returnType)) {
            Call::class.java -> {
                val callType = getParameterUpperBound(0, returnType as ParameterizedType)
                when (getRawType(callType)) {
                    ApiResult::class.java -> {
                        val resultType = getParameterUpperBound(0, callType as ParameterizedType)
                        ResultAdapter(getRawType(resultType))
                    }
                    else -> null
                }
            }
            else -> null
        }
    }
}