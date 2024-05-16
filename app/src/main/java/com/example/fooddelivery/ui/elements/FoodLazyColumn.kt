package com.example.fooddelivery.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.domain.entities.Product
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogCategoryViewModel
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogProductViewModel

@Composable
fun FoodLazyColumn(
    productViewModel: CatalogProductViewModel
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(id = R.dimen.spacer_16))
            .background(color = MaterialTheme.colorScheme.background),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacer_8)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacer_8)),
    ) {
        items(productViewModel.productsFilterList.size) { index ->
            FoodLazyColumnItem(
                index,
                productViewModel,
            )
        }
    }
}

