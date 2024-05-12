package com.softcat.vktest.presentation.pokemonInfo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.softcat.vktest.R
import com.softcat.vktest.domain.entities.Pokemon
import com.softcat.vktest.domain.entities.PokemonCharacteristic
import com.softcat.vktest.domain.entities.PokemonType
import com.softcat.vktest.presentation.extensions.getApplicationComponent
import androidx.compose.foundation.lazy.items
import com.softcat.vktest.ui.theme.TypeLabel

val defaultPokemon = Pokemon(
    100,
    "pokemon's name",
    "infoUrl",
    "frontIconUrl",
    "backIconUrl",
    "frontFemale",
    "backFemale",
    "frontShiny",
    "backShiny",
    listOf(PokemonType("type1"), PokemonType("type2"), PokemonType("type3")),
    listOf(PokemonCharacteristic("name1", 123), PokemonCharacteristic("name2", 1000)),
    1235, 305, 203
)

@Composable
fun ImagePair(modifier: Modifier = Modifier, firstUrl: String?, secondUrl: String?) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val firstBackground = if (firstUrl == null) Color.LightGray else Color.White
        val secondBackground = if (secondUrl == null) Color.LightGray else Color.White
        AsyncImage(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.5f)
                .padding(2.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(firstBackground),
            model = firstUrl,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        AsyncImage(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(2.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(secondBackground),
            model = secondUrl,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun PokemonImagePage(modifier: Modifier = Modifier, pokemon: Pokemon) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
        ImagePair(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
            firstUrl = pokemon.frontIconUrl,
            secondUrl = pokemon.backIconUrl
        )
        ImagePair(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            firstUrl = pokemon.frontFemaleIconUrl ?: pokemon.frontShinyIconUrl,
            secondUrl = pokemon.backFemaleIconUrl ?: pokemon.backShinyIconUrl
        )
    }
}

@Composable
fun TextLabel(
    modifier: Modifier = Modifier, text: String, fontSize: Int) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onBackground
    )
}

fun LazyListScope.pokemonInfoIntroduction(pokemon: Pokemon) {
    item {
        TextLabel(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
                .height(40.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.LightGray),
            text = pokemon.name,
            fontSize = 30
        )
    }
    item {
        PokemonImagePage(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(5.dp),
            pokemon = pokemon
        )
    }
}

@Composable
fun CharacteristicsTableRow(
    name: String,
    value: Int,
    backgroundColor: Color = Color.White,
    fontSize: Int = 16
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(backgroundColor),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight()
                .border(1.dp, Color.Black),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = name,
                fontSize = fontSize.sp
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .border(1.dp, Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value.toString(),
                fontSize = fontSize.sp,
                textAlign = TextAlign.Center
            )
        }

    }
}

@Composable
fun CharacteristicsTable(
    modifier: Modifier = Modifier,
    characteristics: List<PokemonCharacteristic>,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        characteristics.forEach {
            CharacteristicsTableRow(
                name = it.name,
                value = it.value,
                fontSize = 20
            )
        }
    }
}

@Composable
fun PokemonTypes(modifier: Modifier = Modifier, types: List<PokemonType>) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .padding(start = 10.dp),
            text = stringResource(R.string.types_label),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(types, key = { it.name }) {
                Text(
                    modifier = Modifier
                        .height(25.dp)
                        .padding(start = 20.dp)
                        .clip(RoundedCornerShape(50))
                        .background(TypeLabel)
                        .padding(start = 10.dp, end = 10.dp),
                    text = it.name,
                    fontSize = 20.sp,
                )
            }
        }
    }

}

fun LazyListScope.pokemonData(pokemon: Pokemon) {
    item {
        TextLabel(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
                .height(40.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.LightGray),
            text = stringResource(R.string.pokemon_characteristics_label),
            fontSize = 30
        )
    }
    item {
        Spacer(Modifier.height(50.dp))
    }
    item {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            CharacteristicsTable(
                modifier = Modifier
                    .border(2.dp, Color.Black)
                    .fillMaxWidth(0.9f),
                characteristics = pokemon.characteristics
            )
        }
    }
    item {
        PokemonTypes(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(50.dp),
            types = pokemon.types
        )
    }
}

@Preview
@Composable
fun PokemonInfoContent(
    pokemon: Pokemon = defaultPokemon
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        pokemonInfoIntroduction(pokemon)
        item {
            Spacer(Modifier.height(50.dp))
        }
        pokemonData(pokemon)
    }
}

@Composable
fun PokemonInfoScreen(pokemon: Pokemon) {
    val component = getApplicationComponent().getPokemonInfoComponentFactory().create(pokemon)
    val viewModel: PokemonInfoViewModel = viewModel(factory = component.getViewModelFactory())
    val state = viewModel.state.observeAsState(PokemonInfoScreenState.Initial)

    when (val currentState = state.value) {
        is PokemonInfoScreenState.Content -> {
            PokemonInfoContent(pokemon = currentState.pokemon)
        }

        PokemonInfoScreenState.Initial -> {}
    }
}