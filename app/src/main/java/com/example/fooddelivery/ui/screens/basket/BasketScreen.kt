package com.example.fooddelivery.ui.screens.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.domain.entities.AppData
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.elements.BasketAppView
import com.example.fooddelivery.ui.elements.BasketButton
import com.example.fooddelivery.ui.elements.BasketItemElement
import com.example.fooddelivery.ui.screens.basket.view_models.BasketViewModel
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogProductViewModel
import com.example.fooddelivery.ui.utils.advancedShadow

@Composable
fun BasketScreen(
    basketViewModel: BasketViewModel,
    navController: NavController,
    catalogProductViewModel: CatalogProductViewModel
) {

    val owner = LocalLifecycleOwner.current
    var basketState by remember {
        mutableStateOf(basketViewModel.getBasket())
    }

    AppData.basketList.observe(owner) {
        basketState = it
    }

    if (basketState.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background),
        ) {
            Box(modifier = Modifier.weight(0.2f)) {
                BasketAppView(navController = navController)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.8f)
                    .background(color = MaterialTheme.colorScheme.background),
                Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.basket_is_empty),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
        }
    } else {
        Column(
            Modifier.fillMaxSize(),
        ) {
            BasketAppView(navController)
            Box(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
            ) {
                BasketItemElement(basketState, catalogProductViewModel)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .advancedShadow(
                        shadowBlurRadius = 10.dp,
                        alpha = 0.2f
                    )
                    .background(MaterialTheme.colorScheme.background)
                    .padding(horizontal = dimensionResource(id = R.dimen.spacer_16))
            ) {
                BasketButton(
                    text = stringResource(id = R.string.create_order) + " " + "${(AppData.currentPrice.value!! / 100)}" + " " + stringResource(
                        id = R.string.ruble
                    ),
                    currentItem = true,
                    onClick = {})
            }
        }
    }
}