package com.example.doggydays

import com.squareup.moshi.Json

data class Dog (
    @Json(name="message")
    val image:String?,
    @Json(name="status")
    val status: String?,


)