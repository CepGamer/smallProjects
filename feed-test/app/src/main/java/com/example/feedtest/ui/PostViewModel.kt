package com.example.feedtest.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.feedtest.data.AppDatabase
import com.example.feedtest.data.Person
import com.example.feedtest.data.RetrofitClient
import com.example.feedtest.data.toEntity
import com.example.feedtest.data.toPerson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class PeopleUiState {
    object Loading : PeopleUiState()
    data class Success(val people: List<Person>, val hasMore: Boolean) : PeopleUiState()
    data class Error(val message: String) : PeopleUiState()
}

class PeopleViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getInstance(application).personDao()

    private val _uiState = MutableStateFlow<PeopleUiState>(PeopleUiState.Loading)
    val uiState: StateFlow<PeopleUiState> = _uiState

    private var currentPage = 1
    private var isLoadingMore = false

    init {
        fetchPeople()
    }

    fun fetchPeople() {
        currentPage = 1
        _uiState.value = PeopleUiState.Loading
        loadPage()
    }

    fun loadNextPage() {
        if (isLoadingMore) return
        val state = _uiState.value
        if (state is PeopleUiState.Success && !state.hasMore) return
        currentPage++
        loadPage()
    }

    private fun loadPage() {
        isLoadingMore = true
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getPeople(currentPage)
                if (currentPage == 1) dao.clearAll()
                dao.insertAll(response.results.map { it.toEntity() })
                val people = dao.getAllPeople().map { it.toPerson() }
                _uiState.value = PeopleUiState.Success(
                    people = people,
                    hasMore = response.next != null
                )
            } catch (e: Exception) {
                _uiState.value = PeopleUiState.Error(e.message ?: "Unknown error")
            } finally {
                isLoadingMore = false
            }
        }
    }
}
