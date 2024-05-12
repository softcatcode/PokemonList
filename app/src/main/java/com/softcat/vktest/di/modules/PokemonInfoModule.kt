package com.softcat.vktest.di.modules

import androidx.lifecycle.ViewModel
import com.softcat.vktest.di.annotations.ViewModelKey
import com.softcat.vktest.presentation.pokemonInfo.PokemonInfoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PokemonInfoModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokemonInfoViewModel::class)
    fun bindPokemonInfoViewModel(impl: PokemonInfoViewModel): ViewModel
}