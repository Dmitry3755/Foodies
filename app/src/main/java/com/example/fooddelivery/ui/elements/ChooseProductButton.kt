package com.example.fooddelivery.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.LifecycleOwner
import com.example.domain.entities.BasketItem
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogProductViewModel

@Composable
fun ChooseProductButton(
    index: Int,
    productViewModel: CatalogProductViewModel,
    scope: ColumnScope
) {
    val owner: LifecycleOwner = LocalLifecycleOwner.current

    var productState by remember {
        mutableStateOf(productViewModel.basketList.value)
    }

    productViewModel.basketList.observe(owner) {
        productState = it
    }

    scope.run {
        if (productState!!.size != 0)
            Row(
                modifier = Modifier
                    .padding(end = dimensionResource(id = R.dimen.spacer_12))
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(id = R.dimen.spacer_12))
                    .align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable(
                            onClick = {
                                productViewModel.reduceProductOnBasket(productViewModel.productList.value!![index])
                            },
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        )
                        .background(
                            color = MaterialTheme.colorScheme.onPrimary,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_8))
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_minus),
                        contentDescription = stringResource(id = R.string.icon_minus_description),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = productState!!.first { basketItem: BasketItem -> basketItem.product!!.id == productViewModel.productsFilterList[0].id }.count.toString(),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable(
                            onClick = {
                                productViewModel.addProductOnBasket(productViewModel.productsFilterList[index])
                            },
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        )
                        .background(
                            color = MaterialTheme.colorScheme.onPrimary,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_8))
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = stringResource(id = R.string.icon_minus_description),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
    }
}