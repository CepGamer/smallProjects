package com.example.feedtest.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.feedtest.data.Person

@Entity(tableName = "people")
data class PersonEntity(
    @PrimaryKey val url: String,
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val page: Int
)

fun PersonEntity.toPerson() = Person(
    name = name,
    height = height,
    mass = mass,
    hairColor = hairColor,
    skinColor = skinColor,
    eyeColor = eyeColor,
    birthYear = birthYear,
    gender = gender,
    url = url
)

fun Person.toEntity(page: Int) = PersonEntity(
    url = url,
    name = name,
    height = height,
    mass = mass,
    hairColor = hairColor,
    skinColor = skinColor,
    eyeColor = eyeColor,
    birthYear = birthYear,
    gender = gender,
    page = page
)
