package com.example.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fooddelivery.ui.navigation.NavigationGraph
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogCategoryViewModel
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogProductViewModel
import com.example.fooddelivery.ui.screens.product_card.view_models.ProductCardViewModel
import com.example.fooddelivery.ui.theme.FoodDeliveryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val catalogCategoryViewModel: CatalogCategoryViewModel by viewModels()
    private val catalogProductViewModel: CatalogProductViewModel by viewModels()
    private val productCardViewModel: ProductCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodDeliveryTheme {
                NavigationGraph(
                    catalogCategoryViewModel,
                    catalogProductViewModel,
                    productCardViewModel
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodDeliveryTheme {
    }
}