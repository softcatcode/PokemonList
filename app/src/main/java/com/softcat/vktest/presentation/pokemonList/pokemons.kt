package com.softcat.vktest.presentation.pokemonList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.softcat.vktest.domain.entities.Pokemon
import com.softcat.vktest.presentation.extensions.ProgressBar
import com.softcat.vktest.presentation.extensions.getApplicationComponent

@Composable
@Preview
fun PokemonCard(
    pokemon: Pokemon = Pokemon("spider", infoUrl = "https://pokemons/spider", iconUrl = "https://pokemons_icons/spider.png"),
    pokemonClickedListener: (Pokemon) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.White),
        onClick = { pokemonClickedListener(pokemon) }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(10.dp)),
                model = pokemon.iconUrl,
                contentDescription = null
            )
            Text(
                text = pokemon.name,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }

}



@Composable
fun PokemonList(
    pokemons: List<Pokemon>,
    pokemonClickedListener: (Pokemon) -> Unit,
    nextDataLoading: Boolean = false,
    loadNextCallback: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(items = pokemons, key = { it.name } ) {pokemon ->
            PokemonCard(
                pokemon = pokemon,
                pokemonClickedListener = pokemonClickedListener
            )
        }
        item {
            if (nextDataLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    ProgressBar()
                }
            } else {
                SideEffect { loadNextCallback() }
            }
        }
    }
}

@Composable
fun PokemonListScreen(
    pokemonClickedListener: (Pokemon) -> Unit
) {
    val component = getApplicationComponent()
    val viewModel: PokemonsViewModel = viewModel(factory = component.getViewModelFactory())
    val state = viewModel.state.collectAsState(initial = PokemonsScreenState.Initial)

    when (val currentState = state.value) {
        is PokemonsScreenState.Initial -> {}

        is PokemonsScreenState.Loading -> {
            ProgressBar()
        }

        is PokemonsScreenState.Content -> {
            PokemonList(
                pokemons = currentState.pokemons,
                pokemonClickedListener = pokemonClickedListener,
                nextDataLoading = currentState.nextDataLoading,
                loadNextCallback = { viewModel.loadPokemonsPage() }
            )
        }
    }
}