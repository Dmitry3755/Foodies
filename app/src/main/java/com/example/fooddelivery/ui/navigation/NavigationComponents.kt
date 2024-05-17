package com.example.fooddelivery.ui.navigation

import androidx.navigation.Navigation

sealed class NavigationComponents(val route: String) {
    data object CatalogScreen : NavigationComponents("catalog_screen")
    data object ProductCardScreen : NavigationComponents("product_card_screen")
}