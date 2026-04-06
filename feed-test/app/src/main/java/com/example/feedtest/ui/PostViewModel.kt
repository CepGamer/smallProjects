package com.example.feedtest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.feedtest.data.Person
import com.example.feedtest.repository.PeopleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

data class PeopleUiState(
    val people: List<Person> = emptyList(),
    val isLoading: Boolean = false,
    val isLoadingMore: Boolean = false,
    val hasMore: Boolean = true,
    val error: String? = null
)

class PeopleViewModel(private val repository: PeopleRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(PeopleUiState(isLoading = true))
    val uiState: StateFlow<PeopleUiState> = _uiState

    private var nextPage = 1
    private var isFetching = false

    init {
        // Observe Room — UI updates automatically whenever DB changes
        repository.people
            .onEach { people ->
                _uiState.value = _uiState.value.copy(
                    people = people,
                    isLoading = false
                )
            }
            .launchIn(viewModelScope)

        // On first launch fetch page 1; otherwise just show cached data
        viewModelScope.launch {
            val cached = repository.cachedPageCount()
            if (cached == 0) {
                fetchNextPage()
            } else {
                nextPage = cached + 1
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
        }
    }

    fun loadNextPage() {
        if (isFetching || !_uiState.value.hasMore) return
        fetchNextPage()
    }

    fun refresh() {
        if (isFetching) return
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            repository.clearCache()
            nextPage = 1
            fetchNextPage()
        }
    }

    private fun fetchNextPage() {
        isFetching = true
        val page = nextPage
        _uiState.value = _uiState.value.copy(
            isLoadingMore = page > 1,
            error = null
        )
        viewModelScope.launch {
            try {
                val hasMore = repository.fetchPage(page)
                nextPage = page + 1
                _uiState.value = _uiState.value.copy(
                    hasMore = hasMore,
                    isLoadingMore = false
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isLoadingMore = false,
                    // Only surface the error when the cache is also empty
                    error = if (_uiState.value.people.isEmpty()) e.message else null
                )
            } finally {
                isFetching = false
            }
        }
    }

    class Factory(private val repository: PeopleRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return PeopleViewModel(repository) as T
        }
    }
}
