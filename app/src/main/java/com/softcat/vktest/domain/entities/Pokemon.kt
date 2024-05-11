package com.softcat.vktest.domain.entities

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val name: String,
    val infoUrl: String,
    val iconUrl: String
): Parcelable {
    companion object {
        val NavigationType = object: NavType<Pokemon>(isNullableAllowed = false) {

            override fun get(bundle: Bundle, key: String) = bundle.getParcelable(key, Pokemon::class.java)

            override fun parseValue(value: String) = Gson().fromJson(value, Pokemon::class.java)

            override fun put(bundle: Bundle, key: String, value: Pokemon) = bundle.putParcelable(key, value)
        }
    }
}
