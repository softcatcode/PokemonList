package com.softcat.vktest.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonCharacteristic(
    val name: String,
    val value: Int
): Parcelable
