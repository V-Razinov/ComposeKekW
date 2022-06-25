package ru.mediasoft.core_navigation.router

import kotlinx.coroutines.flow.Flow

interface Router {

    val destinations: Flow<RouterEvent>

    fun navigate(destination: Destination): Boolean

    fun back(): Boolean

}