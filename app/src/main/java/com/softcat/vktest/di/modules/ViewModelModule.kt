package com.softcat.vktest.di.modules

import androidx.lifecycle.ViewModel
import com.softcat.vktest.di.annotations.ViewModelKey
import com.softcat.vktest.presentation.pokemonList.PokemonsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokemonsViewModel::class)
    fun bindPokemonsViewModel(impl: PokemonsViewModel): ViewModel
}