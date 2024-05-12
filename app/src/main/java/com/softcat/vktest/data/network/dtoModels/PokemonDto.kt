package com.softcat.vktest.data.network.dtoModels

import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("name") val name: String,
    @SerializedName("url") val infoUrl: String
)
