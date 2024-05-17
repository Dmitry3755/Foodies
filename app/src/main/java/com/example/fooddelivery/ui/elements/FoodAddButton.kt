package com.example.fooddelivery.ui.elements

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.example.domain.entities.BasketItem
import com.example.domain.entities.Product
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.model.AppData
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogProductViewModel
import kotlin.math.roundToInt

@Composable
fun FoodAddButton(
    currentProduct: Product,
    productViewModel: CatalogProductViewModel
) {
    var clickButtonState by remember {
        mutableStateOf(0)
    }

    if (clickButtonState == 0) {
        Button(
            modifier = Modifier
                .padding(end = dimensionResource(id = R.dimen.spacer_12))
                .fillMaxWidth()
                .padding(vertical = dimensionResource(id = R.dimen.spacer_12)),
            onClick = {
                productViewModel.addProductOnBasket(currentProduct, true)
                clickButtonState = 1
            },
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            shape = MaterialTheme.shapes.extraSmall
        ) {
            Row() {
                Text(
                    text = "${currentProduct.priceCurrent.roundToInt() / 100}" + " " + stringResource(
                        id = R.string.ruble
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondary
                )
                if (currentProduct.priceOld != null) {
                    Text(
                        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.spacer_10)),
                        text = "${currentProduct.priceOld!!.roundToInt() / 100}" + " " + stringResource(
                            id = R.string.ruble
                        ),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onTertiary,
                        textDecoration = TextDecoration.LineThrough
                    )
                }
            }
        }
    } else {
        ChooseProductButton(currentProduct, productViewModel)
    }
}