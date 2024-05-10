package com.softcat.vktest.di.modules

import com.softcat.vktest.data.network.api.PokemonApiFactory
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideApiService() = PokemonApiFactory.apiService
}