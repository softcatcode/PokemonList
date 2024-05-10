package com.softcat.vktest.data.network.api

import com.softcat.vktest.data.network.dtoModels.LoadPokemonsResponseDto
import com.softcat.vktest.data.network.dtoModels.PokemonInfoDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon?")
    suspend fun loadPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): LoadPokemonsResponseDto

    @GET("{url}")
    suspend fun loadPokemonInfo(
        @Path("url") infoUrl: String
    ): PokemonInfoDto

    companion object {
        const val API_LINK = "https://pokeapi.co/api/v2/"
    }
}