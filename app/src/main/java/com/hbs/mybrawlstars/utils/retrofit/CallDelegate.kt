package com.hbs.mybrawlstars.utils.retrofit

import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
* link : https://mlog.club/article/798924
* */
abstract class CallDelegate<TIn, TOut>(
    val proxy: Call<TIn>
) : Call<TOut> {
    override fun execute(): Response<TOut> = throw NotImplementedError()
    final override fun enqueue(callback: Callback<TOut>) = enqueueImpl(callback)
    final override fun clone(): Call<TOut> = cloneImpl()

    override fun cancel() = proxy.cancel()
    override fun request(): Request = proxy.request()
    override fun isExecuted() = proxy.isExecuted
    override fun isCanceled() = proxy.isCanceled

    abstract fun enqueueImpl(callback: Callback<TOut>)
    abstract fun cloneImpl(): Call<TOut>
}