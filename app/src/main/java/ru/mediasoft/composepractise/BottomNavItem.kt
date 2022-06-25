package ru.mediasoft.composepractise

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import ru.mediasoft.core_navigation.router.Destination

sealed class BottomNavItem(
    val name: String,
    val icon: ImageVector,
    val destination: Destination
) {
    object Main : BottomNavItem(
        name = "Main",
        icon = Icons.Default.Person,
        destination = MainScreenDestination()
    )

    object Profile : BottomNavItem(
        name = "Profile",
        icon = Icons.Default.Add,
        destination = ProfileScreenDestination()
    )

    object AppInfo : BottomNavItem(
        name = "AppInfo",
        icon = Icons.Default.Info,
        destination = AppInfoScreenDestination()
    )
}