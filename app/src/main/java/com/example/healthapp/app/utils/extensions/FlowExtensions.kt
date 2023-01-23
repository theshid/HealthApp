package com.example.healthapp.app.utils.extensions


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/*
fun <T> Flow<Any>.toDomain(): Flow<T> = map { value ->
    val domain: Any = when (value) {
        is DeepLResponse -> value.toDomain()
        is TranslationResponse -> value.toDomain()
        else -> throw NotImplementedError("value ($value) does not implement toDomain() function.")
    }
    return@map domain as T
}

fun <T> Flow<Any>.toPresentation(): Flow<T> = map { value ->
    val presentation: Any = when (value) {
        is DeepL -> value.toPresentation()
        is Translation -> value.toPresentation()
        else -> throw NotImplementedError("value ($value) does not implement toPresentation() function.")
    }
    return@map presentation as T
}*/
