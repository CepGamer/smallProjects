package com.example.feedtest.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Query("SELECT * FROM people ORDER BY page ASC, url ASC")
    fun observeAll(): Flow<List<PersonEntity>>

    @Query("SELECT MAX(page) FROM people")
    suspend fun maxPage(): Int?

    @Upsert
    suspend fun upsertAll(people: List<PersonEntity>)

    @Query("DELETE FROM people")
    suspend fun deleteAll()
}
