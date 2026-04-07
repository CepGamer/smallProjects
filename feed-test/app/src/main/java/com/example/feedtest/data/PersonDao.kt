package com.example.feedtest.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PersonDao {
    @Query("SELECT * FROM people ORDER BY id ASC")
    suspend fun getAllPeople(): List<PersonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(people: List<PersonEntity>)

    @Query("DELETE FROM people")
    suspend fun clearAll()
}
