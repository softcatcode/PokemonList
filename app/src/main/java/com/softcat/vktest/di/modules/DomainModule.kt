package com.softcat.vktest.di.modules

import com.softcat.vktest.data.implementations.PokemonRepository
import com.softcat.vktest.di.annotations.ApplicationScope
import com.softcat.vktest.domain.interfaces.PokemonRepositoryInterface
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @ApplicationScope
    @Binds
    fun bindPokemonRepository(impl: PokemonRepository): PokemonRepositoryInterface
}