package ru.mediasoft.core_navigation.router

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RouterImpl @Inject constructor() : Router {

    private val navEvents = Channel<RouterEvent>()

    override val destinations = navEvents.receiveAsFlow()

    override fun navigate(destination: Destination): Boolean {
        return navEvents.trySend(RouterEvent.Navigate(destination)).isSuccess
    }

    override fun back(): Boolean {
        return navEvents.trySend(RouterEvent.Back).isSuccess
    }

}