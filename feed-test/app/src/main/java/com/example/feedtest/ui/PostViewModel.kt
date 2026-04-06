package com.example.feedtest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feedtest.data.Person
import com.example.feedtest.data.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class PeopleUiState {
    object Loading : PeopleUiState()
    data class Success(val people: List<Person>, val hasMore: Boolean) : PeopleUiState()
    data class Error(val message: String) : PeopleUiState()
}

class PeopleViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<PeopleUiState>(PeopleUiState.Loading)
    val uiState: StateFlow<PeopleUiState> = _uiState

    private val _people = mutableListOf<Person>()
    private var currentPage = 1
    private var isLoadingMore = false

    init {
        fetchPeople()
    }

    fun fetchPeople() {
        _people.clear()
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
                _people.addAll(response.results)
                _uiState.value = PeopleUiState.Success(
                    people = _people.toList(),
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
