package com.softcat.vktest.di.modules

import com.softcat.vktest.data.implementations.PokemonRepository
import com.softcat.vktest.domain.interfaces.PokemonRepositoryInterface
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindPokemonRepository(impl: PokemonRepository): PokemonRepositoryInterface
}