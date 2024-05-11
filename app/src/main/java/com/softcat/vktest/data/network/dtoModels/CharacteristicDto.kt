package com.softcat.vktest.data.network.dtoModels

import com.google.gson.annotations.SerializedName

data class CharacteristicDto(
    @SerializedName("base_stat") val value: Int,
    @SerializedName("stat") val stat: StatDto
)