package com.example.feedtest.data

import com.google.gson.annotations.SerializedName

data class Person(
    val name: String,
    val height: String,
    val mass: String,
    @SerializedName("hair_color") val hairColor: String,
    @SerializedName("skin_color") val skinColor: String,
    @SerializedName("eye_color") val eyeColor: String,
    @SerializedName("birth_year") val birthYear: String,
    val gender: String,
    val url: String
)

data class SwapiResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Person>
)
