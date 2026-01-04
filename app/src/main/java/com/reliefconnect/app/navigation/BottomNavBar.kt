package com.reliefconnect.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.reliefconnect.app.navigation.Routes


@Composable
fun BottomNavBar(navController: NavController) {

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar {

        NavigationBarItem(
            selected = currentRoute == Routes.HOME,
            onClick = {
                navController.navigate(Routes.HOME) {
                    launchSingleTop = true
                }
            },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = currentRoute == Routes.REQUEST,
            onClick = {
                navController.navigate(Routes.REQUEST) {
                    launchSingleTop = true
                }
            },
            icon = { Icon(Icons.Default.List, contentDescription = null) },
            label = { Text("Requests") }
        )

        NavigationBarItem(
            selected = currentRoute == Routes.PROFILE,
            onClick = {
                navController.navigate(Routes.PROFILE) {
                    launchSingleTop = true
                }
            },
            icon = { Icon(Icons.Default.Person, contentDescription = null) },
            label = { Text("Profile") }
        )
    }
}
