package com.dicoding.jetreward.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.jetreward.data.MovieRepository
import com.dicoding.jetreward.model.MovieList
import com.dicoding.jetreward.model.Movie
import com.dicoding.jetreward.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailMovieViewModel(
    private val repository: MovieRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<MovieList>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<MovieList>>
        get() = _uiState

    fun getRewardById(rewardId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getFavMovieById(rewardId))
        }
    }

    fun addToCart(movie: Movie, count: Int) {
        viewModelScope.launch {
            repository.updateOrderReward(movie.id, count)
        }
    }
}