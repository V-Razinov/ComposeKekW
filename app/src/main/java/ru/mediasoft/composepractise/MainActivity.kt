package ru.mediasoft.composepractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import ru.mediasoft.core_navigation.router.RouterEvent
import ru.mediasoft.core_ui.ui.BottomNav

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val mainViewModel = hiltViewModel<MainViewModel>()
                val navController = rememberNavController()
                val currentRoute = navController.currentDestination?.route

                LaunchedEffect(key1 = navController) {
                    mainViewModel.destinations.collect {
                        when (val event = it) {
                            RouterEvent.Back -> {
                                navController.popBackStack()
                            }
                            is RouterEvent.Navigate -> {
                                navController.navigate(
                                    route = event.destination.route,
                                ) {
//                                    navArgument(event.destination.arguments)
                                }
                            }
                        }
                    }
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        bottomBar = {
                            BottomNav {
                                bottomNavItems.forEach { navItem ->
                                    BottomNavigationItem(
                                        selected = navItem.destination.route == currentRoute,
                                        icon = { Icon(imageVector = navItem.icon, contentDescription = navItem.name) },
                                        label = { Text(text = navItem.name) },
                                        onClick = { mainViewModel.navigate(navItem.destination) }
                                    )
                                }
                            }
                        }
                    ) { paddingValues ->
                        NavHost(
                            modifier = Modifier.padding(paddingValues),
                            navController = navController,
                            startDestination = MainScreenDestination().route,
                        ) {
                            bottomNavItems.forEachIndexed { index, navItem ->
                                composable(
                                    navItem.destination.route,
                                    navItem.destination.arguments,
                                ) {
                                    MainScreen(index.toString() + navItem.destination.route)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun MainScreen(route: String) {
    Box {
        Text(text = route)
    }
}

val bottomNavItems = listOf(BottomNavItem.Main, BottomNavItem.Profile, BottomNavItem.AppInfo)