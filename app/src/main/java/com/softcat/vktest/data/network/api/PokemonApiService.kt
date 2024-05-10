package com.softcat.vktest.data.network.api

import com.softcat.vktest.data.network.dtoModels.LoadPokemonsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon?")
    fun loadPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): LoadPokemonsResponseDto

    companion object {
        const val API_LINK = "https://pokeapi.co/api/v2/"
    }
}