package com.shubhit.livescore.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhit.livescore.model.CurrentMatches
import com.shubhit.livescore.model.NetworkError
import com.shubhit.livescore.model.NetworkResult
import com.shubhit.livescore.repo.CurrentMatchRepo
import kotlinx.coroutines.launch

class CurrentMatchesViewModel:ViewModel() {
    val currentMatchResult= MutableLiveData<CurrentMatches>()
    val error= MutableLiveData<NetworkError>()

    fun getCurrentMatches(params:Map<String,String>){
        viewModelScope.launch {
            when(val result = CurrentMatchRepo.getCurrentMatches(params)){
                is NetworkResult.Success->currentMatchResult.postValue(result.data)
                is NetworkResult.Error->error.postValue(result.networkError)

            }
        }

    }

}