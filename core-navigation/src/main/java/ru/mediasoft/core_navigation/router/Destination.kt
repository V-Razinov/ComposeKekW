package ru.mediasoft.core_navigation.router

import androidx.navigation.NamedNavArgument

interface Destination {

    val route: String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

}

