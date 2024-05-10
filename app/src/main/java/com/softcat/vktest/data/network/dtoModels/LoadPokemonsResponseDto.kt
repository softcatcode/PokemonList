package com.softcat.vktest.data.network.dtoModels

import com.google.gson.annotations.SerializedName

data class LoadPokemonsResponseDto(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val nextPageUrl: String,
    @SerializedName("results") val pokemonList: List<PokemonDto>
)
