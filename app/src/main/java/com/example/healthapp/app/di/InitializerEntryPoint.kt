package com.example.healthapp.app.di

import android.content.Context
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface InitializerEntryPoint {
    companion object {
        private fun resolve(context: Context): InitializerEntryPoint {
            val appContext = context.applicationContext
            return EntryPointAccessors.fromApplication(
                appContext,
                InitializerEntryPoint::class.java
            )
        }

        operator fun invoke(context: Context): InitializerEntryPoint = resolve(context)
    }

   /* fun inject(initializer: WorkManagerInitializer)
    fun inject(initializer: ScheduledWorkInitializer)*/

}