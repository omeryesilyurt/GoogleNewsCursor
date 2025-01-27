package com.example.googlenewscursor.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.googlenewscursor.presentation.screens.favorites.FavoritesScreen
import com.example.googlenewscursor.presentation.screens.home.HomeScreen
import com.example.googlenewscursor.presentation.screens.search.SearchScreen
import androidx.compose.ui.Modifier

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route,
        modifier = modifier
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Search.route) {
            SearchScreen()
        }
        composable(NavigationItem.Favorites.route) {
            FavoritesScreen()
        }
    }
} 