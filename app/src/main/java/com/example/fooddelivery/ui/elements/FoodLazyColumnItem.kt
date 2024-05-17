package com.example.fooddelivery.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.domain.entities.Product
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.navigation.NavigationComponents
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogProductViewModel

@Composable
fun FoodLazyColumnItem(
    index: Int,
    productViewModel: CatalogProductViewModel,
    navController: NavController,
) {

    var currentProduct = productViewModel.getProductsFilterList()[index]

    Card(
        modifier = Modifier
            .width(LocalConfiguration.current.screenWidthDp.dp / 2)
            .height(LocalConfiguration.current.screenHeightDp.dp * 10 / 28)
            .clickable(
                onClick = {
                    navController.navigate(NavigationComponents.ProductCardScreen.route + "/${currentProduct.id}")
                },
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_8)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(start = dimensionResource(id = R.dimen.spacer_12)),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.spacer_10)),
            ) {
                if (currentProduct.priceOld != null)
                    Icon(
                        painter = painterResource(id = R.drawable.ic_discount),
                        tint = Color.Unspecified,
                        contentDescription = stringResource(id = R.string.icon_discount_description)
                    )
                Image(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    painter = painterResource(id = R.drawable.image_food),
                    contentDescription = stringResource(id = R.string.image_food_description)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = dimensionResource(id = R.dimen.spacer_12)),
                    text = currentProduct.name,
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    modifier = Modifier
                        .padding(top = dimensionResource(id = R.dimen.spacer_4)),
                    text = "${currentProduct.measure} ${currentProduct.measureUnit}",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.2f),
            ) {
                FoodAddButton(
                    currentProduct,
                    productViewModel
                )
            }
        }
    }
}