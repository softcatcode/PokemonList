package com.softcat.vktest.data.network.dtoModels

import com.google.gson.annotations.SerializedName

data class PokemonTextureDto(
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("front_shiny_female") val frontShinyFemale: String?,
    @SerializedName("back_shiny_female") val backShinyFemale: String?,
    @SerializedName("front_female") val frontFemale: String?,
    @SerializedName("back_female") val backFemale: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("back_shiny") val backShiny: String?
)
