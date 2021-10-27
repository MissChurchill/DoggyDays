package com.example.doggydays

import com.squareup.moshi.Json

data class Dog (
    @Json(name="image")
    val image:DogImage,
    @Json(name="status")
    val status: String?,


)