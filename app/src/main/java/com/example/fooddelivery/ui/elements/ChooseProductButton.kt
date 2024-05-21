package com.example.fooddelivery.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.domain.entities.BasketItem
import com.example.domain.entities.Product
import com.example.fooddelivery.R
import com.example.domain.entities.AppData
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogProductViewModel

@Composable
fun ChooseProductButton(
    currentProduct: Product,
    productViewModel: CatalogProductViewModel,
    isBasket: Boolean
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    var countCurrentItemBasket by remember {
        mutableStateOf(
            productViewModel.getBasketList()
                .first { basketItem: BasketItem -> basketItem.product!!.id == currentProduct.id }.count.value
        )
    }
    val index = productViewModel.getBasketList().indexOf(productViewModel.getBasketList()
        .first { basketItem: BasketItem -> basketItem.product!!.id == currentProduct.id })

    AppData.basketList.value!![index].count.observe(lifecycleOwner) {
        countCurrentItemBasket = it
    }

    if (countCurrentItemBasket != 0)
        Row(
            modifier = Modifier
                .padding(end = dimensionResource(id = R.dimen.spacer_12))
                .fillMaxSize()
                .padding(vertical = dimensionResource(id = R.dimen.spacer_12)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(0.3f)
                    .clickable(
                        onClick = {
                            productViewModel.reduceProductOnBasket(currentProduct)
                        },
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    )
                    .background(
                        color = if (isBasket) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onPrimary,
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
                    .weight(0.3f)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = productViewModel.getBasketList()
                        .first { basketItem: BasketItem -> basketItem.product!!.id == currentProduct.id }.count.value!!.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxHeight()
                    .clickable(
                        onClick = {
                            productViewModel.addProductOnBasket(
                                currentProduct,
                                false
                            )
                        },
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    )
                    .background(
                        color = if (isBasket) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onPrimary,
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
