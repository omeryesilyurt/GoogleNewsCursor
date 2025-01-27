package com.example.googlenewscursor.presentation.navigation

import com.example.googlenewscursor.R

sealed class NavigationItem(val route: String, val icon: Int, val title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Search : NavigationItem("search", R.drawable.ic_search, "Search")
    object Favorites : NavigationItem("favorites", R.drawable.ic_favorite, "Favorites")
} 