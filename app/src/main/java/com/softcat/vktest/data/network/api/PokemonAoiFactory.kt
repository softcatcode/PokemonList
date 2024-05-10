package com.softcat.vktest.data.network.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

object PokemonAoiFactory {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        ).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(PokemonApiService.API_LINK)
        .client(okHttpClient)
        .build()

    val apiService: PokemonApiService = retrofit.create()
}