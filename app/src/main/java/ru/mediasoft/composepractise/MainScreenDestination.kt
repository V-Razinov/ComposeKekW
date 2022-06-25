package ru.mediasoft.composepractise

import ru.mediasoft.core_navigation.router.Destination

class MainScreenDestination : Destination {
    override val route: String = "main"
}

class ProfileScreenDestination : Destination {
    override val route: String = "profile"
}

class AppInfoScreenDestination : Destination {
    override val route: String = "info"
}