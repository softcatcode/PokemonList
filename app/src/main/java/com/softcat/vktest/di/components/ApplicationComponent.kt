package com.softcat.vktest.di.components

import com.softcat.vktest.di.annotations.ApplicationScope
import com.softcat.vktest.di.ViewModelFactory
import com.softcat.vktest.di.modules.DataModule
import com.softcat.vktest.di.modules.ViewModelModule
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun getViewModelFactory(): ViewModelFactory
}