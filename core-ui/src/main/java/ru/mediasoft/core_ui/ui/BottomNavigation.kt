package ru.mediasoft.core_ui.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BottomNav(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    BottomNavigation(
        modifier = modifier,
        content = content
    )
}

//@Composable
//fun BottomNavItem(
//    modifier: Modifier = Modifier,
//    selected: Boolean,
//    icon: @Composable () -> Unit,
//    enabled: Boolean = true,
//) = BottomNavigationItem(
//
//)