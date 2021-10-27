package com.example.doggydays

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    //private val _currentlyDisplayedDog = MutableLiveData<Dog>()
    //val currentlyDisplayedDog: LiveData<Dog> = _currentlyDisplayedDog

    private val _currentlyDisplayedDog = MutableLiveData<Dog>()
    val currentlyDisplayedDog: LiveData<Dog> = _currentlyDisplayedDog

    init{
    getNewDog()
}
    fun getNewDog() {
        viewModelScope.launch {
            // The response from https://dog.ceo/api/breeds/image/random
            //val response = DogApi.retrofitService.getRandomDog()
            //_currentlyDisplayedDog.value = response.status!!

            _currentlyDisplayedDog.value = DogApi.retrofitService.getRandomDog()
        }
        }
    }
