package com.shubhit.livescore.network

import com.shubhit.livescore.model.CurrentMatches
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface APIService {
    @GET("currentMatches")
    suspend fun getCurrentMatches(
        @QueryMap params:Map<String,String>
    ):Response<CurrentMatches>




}