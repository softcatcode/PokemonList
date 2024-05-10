package com.softcat.vktest.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.softcat.vktest.ui.theme.VkTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkTestTheme {
                PokemonAppMainScreen()
            }
        }
    }
}
