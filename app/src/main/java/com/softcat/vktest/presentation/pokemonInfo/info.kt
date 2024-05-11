package com.softcat.vktest.presentation.pokemonInfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.softcat.vktest.domain.entities.Pokemon
import com.softcat.vktest.domain.entities.PokemonCharacteristic
import com.softcat.vktest.domain.entities.PokemonType
import com.softcat.vktest.presentation.extensions.getApplicationComponent

@Preview
@Composable
fun PokemonInfoContent(
    pokemon: Pokemon = Pokemon(
        100,
        "name",
        "infoUrl",
        "frontIconUrl",
        "backIconUrl",
        "frontFemale",
        "backFemale",
        listOf(PokemonType("type1"), PokemonType("type2"), PokemonType("type3")),
        listOf(PokemonCharacteristic("name1", 123), PokemonCharacteristic("name2", 1000)),
        1235, 305, 203
    )
) {

}

@Composable
fun PokemonInfoScreen(pokemon: Pokemon) {
    val component = getApplicationComponent().getPokemonInfoComponentFactory().create(pokemon)
    val viewModel: PokemonInfoViewModel = viewModel(factory = component.getViewModelFactory())
    val state = viewModel.state.observeAsState(PokemonInfoScreenState.Initial)

    when (val currentState = state.value) {
        is PokemonInfoScreenState.Content -> {
            PokemonInfoContent(currentState.pokemon)
        }

        PokemonInfoScreenState.Initial -> {}
    }
}