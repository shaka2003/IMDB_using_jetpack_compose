package com.dicoding.jetreward.di

import com.dicoding.jetreward.data.MovieRepository


object Injection {
    fun provideRepository(): MovieRepository {
        return MovieRepository.getInstance()
    }
}