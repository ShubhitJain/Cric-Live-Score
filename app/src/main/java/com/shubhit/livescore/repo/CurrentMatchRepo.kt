package com.shubhit.livescore.repo

import com.google.gson.GsonBuilder
import com.shubhit.livescore.model.CurrentMatches
import com.shubhit.livescore.model.ErrorBody
import com.shubhit.livescore.model.NetworkError
import com.shubhit.livescore.model.NetworkResult
import com.shubhit.livescore.network.APIService
import com.shubhit.livescore.network.NetworkModule
import retrofit2.create
import java.io.IOException

object CurrentMatchRepo {
    private val apiClient:APIService=NetworkModule.providesRetrofit().create(APIService::class.java)

    suspend fun getCurrentMatches(params:Map<String,String>):NetworkResult<CurrentMatches>{
        return try {
            val response=CurrentMatchRepo.apiClient.getCurrentMatches(params)
            if (response.isSuccessful){
                NetworkResult.Success(response.body() as CurrentMatches)
            }else{
                NetworkResult.Error(
                    NetworkError(
                        IOException("Error Occures"),
                        response.code(),
                        GsonBuilder().create().fromJson<ErrorBody>(
                            response.errorBody()!!.charStream(),
                            ErrorBody::class.java
                        ).message
                    )
                )
            }
        }catch (e:Exception){
            NetworkResult.Error(
                NetworkError(
                    IOException(e.message),
                    0
                )
            )
        }

    }


}