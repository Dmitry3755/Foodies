package com.example.fooddelivery.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.ui.screens.catalog.CatalogScreen
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogCategoryViewModel
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogProductViewModel

@Composable
fun NavigationGraph() {

    val navController = rememberNavController()
    val catalogCategoryViewModel: CatalogCategoryViewModel = hiltViewModel()
    val catalogProductViewModel: CatalogProductViewModel = hiltViewModel()

    NavHost(
        navController,
        startDestination = NavigationComponents.CatalogScreen.route
    ) {
        composable(NavigationComponents.CatalogScreen.route) {
            CatalogScreen(
                categoryViewModel = catalogCategoryViewModel,
                productViewModel = catalogProductViewModel
            )
        }
    }
}