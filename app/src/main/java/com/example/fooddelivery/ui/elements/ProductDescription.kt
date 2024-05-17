package com.example.fooddelivery.ui.elements

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.entities.Product
import com.example.fooddelivery.R

@Composable
fun ProductDescription(
    product: Product
) {
    Text(
        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.spacer_16)),
        text = product.name,
        style = MaterialTheme.typography.displayLarge,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
    )
    Text(
        modifier = Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.spacer_16))
            .padding(top = dimensionResource(id = R.dimen.spacer_8)),
        text = product.description,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W400,
        lineHeight = 26.sp,
        color = MaterialTheme.colorScheme.onTertiary
    )
    Column(
        modifier = Modifier
            .padding(top = dimensionResource(id = R.dimen.spacer_24))
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.tertiary)
        Row(
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(id = R.dimen.spacer_16),
                    horizontal = dimensionResource(id = R.dimen.spacer_16)
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.measure),
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(text = product.measure.toString() + product.measureUnit)
        }
        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.tertiary)
        Row(
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(id = R.dimen.spacer_16),
                    horizontal = dimensionResource(id = R.dimen.spacer_16)
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.energy),
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(text = product.energyPerHundredGrams.toString() + stringResource(id = R.string.calories))
        }
        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.tertiary)
        Row(
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(id = R.dimen.spacer_16),
                    horizontal = dimensionResource(id = R.dimen.spacer_16)
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.proteins),
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(text = product.proteinsPerHundredGrams.toString() + product.measureUnit)
        }
        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.tertiary)
        Row(
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(id = R.dimen.spacer_16),
                    horizontal = dimensionResource(id = R.dimen.spacer_16)
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.fats),
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(text = product.fatsPerHundredGrams.toString() + product.measureUnit)
        }
        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.tertiary)
        Row(
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(id = R.dimen.spacer_16),
                    horizontal = dimensionResource(id = R.dimen.spacer_16)
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.carbohydrates),
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(text = product.carbohydratesPerHundredGrams.toString() + product.measureUnit)
        }
        HorizontalDivider(thickness = 2.dp, color = MaterialTheme.colorScheme.tertiary)
    }
}