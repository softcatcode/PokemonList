package com.softcat.vktest.di.modules

import com.softcat.vktest.data.network.api.PokemonApiFactory
import com.softcat.vktest.di.annotations.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @ApplicationScope
    @Provides
    fun provideApiService() = PokemonApiFactory.apiService
}