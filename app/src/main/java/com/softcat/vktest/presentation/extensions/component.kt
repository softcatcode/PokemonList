package com.softcat.vktest.presentation.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.softcat.vktest.PokemonApplication

@Composable
fun getApplicationComponent() =
    (LocalContext.current.applicationContext as PokemonApplication).component