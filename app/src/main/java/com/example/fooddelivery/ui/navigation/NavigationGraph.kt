package com.example.fooddelivery.ui.navigation

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.ui.screens.basket.BasketScreen
import com.example.fooddelivery.ui.screens.basket.view_models.BasketViewModel
import com.example.fooddelivery.ui.screens.catalog.CatalogScreen
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogCategoryViewModel
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogProductViewModel
import com.example.fooddelivery.ui.screens.product_card.ProductCardScreen
import com.example.fooddelivery.ui.screens.product_card.view_models.ProductCardViewModel

@Composable
fun NavigationGraph(
    catalogCategoryViewModel: CatalogCategoryViewModel,
    catalogProductViewModel: CatalogProductViewModel,
    productCardViewModel: ProductCardViewModel,
    basketViewModel: BasketViewModel
) {

    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = NavigationComponents.CatalogScreen.route
    ) {
        composable(NavigationComponents.CatalogScreen.route) {
            CatalogScreen(
                categoryViewModel = catalogCategoryViewModel,
                productViewModel = catalogProductViewModel,
                navController = navController
            )
        }
        composable(NavigationComponents.ProductCardScreen.route + "/{id}") {
            val id = it.arguments?.getString("id")!!
            ProductCardScreen(
                id = id.toInt(),
                productCardViewModel = productCardViewModel,
                navController = navController
            )
        }
        composable(NavigationComponents.BasketScreen.route) {
            BasketScreen(
                basketViewModel = basketViewModel,
                catalogProductViewModel = catalogProductViewModel,
                navController = navController
            )
        }
    }
}