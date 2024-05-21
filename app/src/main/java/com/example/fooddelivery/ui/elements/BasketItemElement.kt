package com.example.fooddelivery.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.domain.entities.BasketItem
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogProductViewModel
import com.example.fooddelivery.ui.screens.product_card.view_models.ProductCardViewModel
import kotlin.math.roundToInt

@Composable
fun BasketItemElement(
    basketState: MutableList<BasketItem>,
    catalogProductViewModel: CatalogProductViewModel
) {
    LazyColumn(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
        content = {
            items(basketState.size) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(1f),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        Modifier
                            .weight(0.3f)
                            .padding(horizontal = 10.dp)
                    ) {
                        Image(
                            modifier = Modifier.align(Alignment.CenterEnd),
                            painter = painterResource(id = R.drawable.image_food),
                            contentDescription = stringResource(id = R.string.image_food_description)
                        )
                    }
                    Column(
                        Modifier
                            .weight(0.5f)
                            .padding(horizontal = 10.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = basketState[it].product!!.name)
                        ChooseProductButton(
                            currentProduct = basketState[it].product!!,
                            productViewModel = catalogProductViewModel,
                            true
                        )
                    }
                    Column(
                        Modifier
                            .weight(0.2f)
                            .padding(horizontal = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "${basketState[it].product!!.priceCurrent.roundToInt() / 100}" + " " + stringResource(
                                id = R.string.ruble
                            ),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                        if (basketState[it].product!!.priceOld != null) {
                            Text(
                                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.spacer_10)),
                                text = "${basketState[it].product!!.priceOld!!.roundToInt() / 100}" + " " + stringResource(
                                    id = R.string.ruble
                                ),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onTertiary,
                                textDecoration = TextDecoration.LineThrough
                            )
                        }
                    }
                }
                HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.tertiary)
            }
        }
    )
}