package com.example.doggydays

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    //private val _currentlyDisplayedDog = MutableLiveData<Dog>()
    //val currentlyDisplayedDog: LiveData<Dog> = _currentlyDisplayedDog

    private val _currentlyDisplayedDog = MutableLiveData<String>()
    val currentlyDisplayedDog: LiveData<String> = _currentlyDisplayedDog

    private val _currentlyDisplayedDogImage = MutableLiveData<DogImage>()
    val currentlyDisplayedDogImage: LiveData<DogImage> = _currentlyDisplayedDogImage


    fun getNewDog() {
        viewModelScope.launch {
            // The response from https://dog.ceo/api/breeds/image/random
            val response = DogApi.retrofitService.getRandomDog(String.Companion)
            _currentlyDisplayedDog.value = response.status!!

            _currentlyDisplayedDogImage.value = response.image
        }
    }
}