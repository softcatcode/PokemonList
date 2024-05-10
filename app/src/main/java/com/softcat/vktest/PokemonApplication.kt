package com.softcat.vktest

import android.app.Application
import com.softcat.vktest.di.components.DaggerApplicationComponent

class PokemonApplication: Application() {
    val component by lazy {
        DaggerApplicationComponent.create()
    }
}