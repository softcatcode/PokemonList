package com.softcat.vktest.domain.entities

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val id: Int,
    val name: String,
    val infoUrl: String,
    val frontIconUrl: String,
    val backIconUrl: String,
    val frontFemaleIconUrl: String,
    val backFemaleIconUrl: String,
    val types: List<PokemonType>,
    val characteristics: List<PokemonCharacteristic>,
    val experience: Int,
    val weight: Int,
    val height: Int
): Parcelable {
    companion object {
        val NavigationType = object: NavType<Pokemon>(isNullableAllowed = false) {

            override fun get(bundle: Bundle, key: String) = bundle.getParcelable(key, Pokemon::class.java)

            override fun parseValue(value: String) = Gson().fromJson(value, Pokemon::class.java)

            override fun put(bundle: Bundle, key: String, value: Pokemon) = bundle.putParcelable(key, value)
        }
    }
}
