package ru.mediasoft.core_navigation.router

sealed class RouterEvent {
    data class Navigate(val destination: Destination) : RouterEvent()
    object Back : RouterEvent()
}