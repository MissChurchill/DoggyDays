package com.example.doggydays

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _currentlyDisplayedDog = MutableLiveData<Dog>()
    val currentlyDisplayedDog: LiveData<Dog> = _currentlyDisplayedDog

    init {
        getNewDog()
    }

    fun getNewDog() {
        viewModelScope.launch {
            // The response from https://dog.ceo/api/breeds/image/random is a list of 1 dog, so we
            // are getting the first item in the list from the response.
            _currentlyDisplayedDog.value = DogApi.retrofitService.getRandomDog()[0]

        }
    }
}