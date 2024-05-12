package com.softcat.vktest.di.components

import com.softcat.vktest.di.ViewModelFactory
import com.softcat.vktest.di.modules.PokemonInfoModule
import com.softcat.vktest.domain.entities.Pokemon
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [PokemonInfoModule::class])
interface PokemonInfoScreenComponent {
    fun getViewModelFactory(): ViewModelFactory

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance pokemon: Pokemon
        ): PokemonInfoScreenComponent
    }

}