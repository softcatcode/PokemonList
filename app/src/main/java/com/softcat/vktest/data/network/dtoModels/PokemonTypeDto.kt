package com.softcat.vktest.data.network.dtoModels

import com.google.gson.annotations.SerializedName

data class PokemonTypeDto(
    @SerializedName("slot") val slot: Int,
    @SerializedName("type") val type: PokemonTypeInfoDto
)
