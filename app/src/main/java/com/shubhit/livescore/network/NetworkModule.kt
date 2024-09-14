package com.shubhit.livescore.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    private val okHttpClientUserSpecific = OkHttpClient()
        .newBuilder()
        .connectTimeout(120L, java.util.concurrent.TimeUnit.SECONDS)
        .readTimeout(120L, java.util.concurrent.TimeUnit.SECONDS)
        .writeTimeout(120L, java.util.concurrent.TimeUnit.SECONDS)
        .addInterceptor(run {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        })
// .certificatePinner(certPinner)
        .build()



    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.cricapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClientUserSpecific)
            .build()
    }
}