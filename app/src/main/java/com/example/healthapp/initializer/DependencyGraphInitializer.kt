package com.example.healthapp.initializer

import android.content.Context
import androidx.startup.Initializer
import com.example.healthapp.app.di.InitializerEntryPoint


/**
 * This initializer will init entry point for injectable initializers before any other initializer.
 * !!! Include this Initializer as dependency in all of your injectable initializers !!!
 */
@Suppress("unused")
class DependencyGraphInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        InitializerEntryPoint(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}