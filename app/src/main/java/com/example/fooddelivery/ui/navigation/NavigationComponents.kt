package com.example.fooddelivery.ui.navigation

sealed class NavigationComponents(val route: String) {
    data object CatalogScreen : NavigationComponents("catalog_screen")
    data object ProductCardScreen : NavigationComponents("product_card_screen")
    data object BasketScreen : NavigationComponents("basket_screen")
}