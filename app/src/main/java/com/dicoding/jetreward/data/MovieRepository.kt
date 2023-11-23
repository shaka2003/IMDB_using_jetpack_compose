package com.dicoding.jetreward.data

import com.dicoding.jetreward.model.FakeRewardDataSource
import com.dicoding.jetreward.model.Movie
import com.dicoding.jetreward.model.MovieList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf

class MovieRepository {

    private val movieLists = mutableListOf<MovieList>()

    init {
        if (movieLists.isEmpty()) {
            FakeRewardDataSource.dummyMovies.forEach {
                movieLists.add(MovieList(it))
            }
        }
    }

    fun getAllMovies(): Flow<List<MovieList>> {
        return flowOf(movieLists)
    }

    fun getFavMovieById(rewardId: Long): MovieList {
        return movieLists.first {
            it.movie.id == rewardId
        }
    }

    fun updateOrderReward(rewardId: Long, newCountValue: Int): Flow<Boolean> {
        val index = movieLists.indexOfFirst { it.movie.id == rewardId }
        val result = if (index >= 0) {
            val orderReward = movieLists[index]
            movieLists[index] =
                orderReward.copy(movie = orderReward.movie)
            true
        } else {
            false
        }
        return flowOf(result)
    }

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(): MovieRepository =
            instance ?: synchronized(this) {
                MovieRepository().apply {
                    instance = this
                }
            }
    }

    fun searchHeroes(query: String): List<Movie>{
        return FakeRewardDataSource.dummyMovies.filter {
            it.title.contains(query, ignoreCase = true)
        }
    }
}