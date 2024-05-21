package com.example.fooddelivery.ui.screens.product_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.domain.entities.Product
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.elements.BackOutlinedButton
import com.example.fooddelivery.ui.elements.BasketButton
import com.example.fooddelivery.ui.elements.ProductDescription
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogProductViewModel
import com.example.fooddelivery.ui.screens.product_card.view_models.ProductCardViewModel
import com.example.fooddelivery.ui.utils.advancedShadow
import kotlin.math.roundToInt

@Composable
fun ProductCardScreen(
    id: Int,
    productCardViewModel: ProductCardViewModel,
    navController: NavController
) {

    val currentProduct = productCardViewModel.getCurrentProduct(id)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            Modifier
                .padding(
                    top = dimensionResource(id = R.dimen.spacer_16),
                    start = dimensionResource(id = R.dimen.spacer_16)
                )
                .fillMaxWidth()
                .weight(0.4f)
        ) {
            BackOutlinedButton(navController)
            Image(
                modifier = Modifier.align(Alignment.CenterEnd),
                painter = painterResource(id = R.drawable.image_food),
                contentDescription = stringResource(id = R.string.image_food_description)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
        ) {
            ProductDescription(
                productCardViewModel.getProductsFilterList()
                    .first { product: Product -> product.id == id })
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f)
                .advancedShadow(
                    shadowBlurRadius = 10.dp,
                    alpha = 0.2f
                )
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = dimensionResource(id = R.dimen.spacer_16)),
            contentAlignment = Alignment.TopCenter
        ) {
            BasketButton(
                text = stringResource(id = R.string.on_basket_product_text_button) + " " +
                        "${currentProduct.priceCurrent.roundToInt() / 100}"
                        + " " + stringResource(id = R.string.ruble),
                true,
                onClick = { productCardViewModel.addProductOnBasket(currentProduct) }
            )
        }
    }
}