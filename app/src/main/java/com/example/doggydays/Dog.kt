package com.example.doggydays

import com.squareup.moshi.Json

data class Dog (
    @Json(name="url")
    val message:String?,
    @Json(name="status")
    val status: String?,


)