package com.example.feedtest.repository

import com.example.feedtest.data.RetrofitClient
import com.example.feedtest.db.AppDatabase
import com.example.feedtest.db.toPerson
import com.example.feedtest.db.toEntity
import com.example.feedtest.data.Person
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PeopleRepository(private val db: AppDatabase) {

    /** UI always observes Room — single source of truth. */
    val people: Flow<List<Person>> = db.personDao()
        .observeAll()
        .map { entities -> entities.map { it.toPerson() } }

    /**
     * Fetch [page] from the network and upsert into Room.
     * Returns true if there is a next page.
     * Throws on network failure — caller handles it.
     */
    suspend fun fetchPage(page: Int): Boolean {
        val response = RetrofitClient.instance.getPeople(page)
        db.personDao().upsertAll(response.results.map { it.toEntity(page) })
        return response.next != null
    }

    /** How many pages are already cached. 0 means the DB is empty. */
    suspend fun cachedPageCount(): Int = db.personDao().maxPage() ?: 0

    suspend fun clearCache() = db.personDao().deleteAll()
}
