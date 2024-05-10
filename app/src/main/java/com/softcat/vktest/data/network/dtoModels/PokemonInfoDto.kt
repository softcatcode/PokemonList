package com.softcat.vktest.data.network.dtoModels

import com.google.gson.annotations.SerializedName

data class PokemonInfoDto(
    @SerializedName("sprites") val texture: PokemonTextureDto
)