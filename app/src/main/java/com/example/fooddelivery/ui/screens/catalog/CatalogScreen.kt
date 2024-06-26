package com.example.fooddelivery.ui.screens.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.domain.entities.AppData
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.elements.AppView
import com.example.fooddelivery.ui.elements.BasketButton
import com.example.fooddelivery.ui.elements.CategoriesAppBar
import com.example.fooddelivery.ui.elements.FoodLazyColumn
import com.example.fooddelivery.ui.navigation.NavigationComponents
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogCategoryViewModel
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogProductViewModel

@Composable
fun CatalogScreen(
    categoryViewModel: CatalogCategoryViewModel,
    productViewModel: CatalogProductViewModel,
    navController: NavController
) {

    val configuration = LocalConfiguration.current
    val owner: LifecycleOwner = LocalLifecycleOwner.current
    var categoryLoading by remember {
        mutableStateOf(categoryViewModel.categoryList.value)
    }
    var productLoading by remember {
        mutableStateOf(productViewModel.productList.value)
    }
    var changeCategory by remember {
        mutableStateOf(categoryViewModel.selectedCategoryButton.value)
    }
    var price by remember {
        mutableStateOf(
            AppData.currentPrice.value
        )
    }

    LaunchedEffect(productLoading, categoryLoading) {
        categoryViewModel.getAllCategories()
        productViewModel.getAllProducts()
    }

    categoryViewModel.selectedCategoryButton.observe(owner) {
        changeCategory = it
    }

    categoryViewModel.categoryList.observe(owner) {
        categoryLoading = it
    }

    productViewModel.productList.observe(owner) {
        productLoading = it
        productViewModel.filterList(categoryViewModel.selectedCategoryButton.value!!)
    }

    AppData.currentPrice.observe(owner) {
        price = it
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = dimensionResource(id = R.dimen.spacer_10))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.125f),
            contentAlignment = Alignment.BottomCenter
        ) {
            AppView()
        }
        if (categoryViewModel.categoryList.value == null || productViewModel.productList.value == null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(0.065f),
            ) {
                CategoriesAppBar(configuration, categoryViewModel, mutableListOf())
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(0.89f),
            ) {
                FoodLazyColumn(
                    productViewModel,
                    navController,
                    0
                )
            }

        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(0.065f),
            ) {

                CategoriesAppBar(
                    configuration,
                    categoryViewModel,
                    categoryViewModel.categoryList.value!!.toMutableList()
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(0.89f),
            ) {
                FoodLazyColumn(
                    productViewModel,
                    navController,
                    changeCategory!!
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            BasketButton(
                " " + "${(price!! / 100)}" + " " + stringResource(id = R.string.ruble),
                false,
                onClick = { navController.navigate(NavigationComponents.BasketScreen.route) }
            )
        }
    }
}

@Composable
@Preview
fun CatalogScreenPreview() {
    val navController = rememberNavController()
    CatalogScreen(viewModel(), viewModel(), navController)
}