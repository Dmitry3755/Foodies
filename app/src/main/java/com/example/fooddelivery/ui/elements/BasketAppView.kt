package com.example.fooddelivery.ui.elements

import android.graphics.drawable.Icon
import android.graphics.drawable.ShapeDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.utils.advancedShadow

@Composable
fun BasketAppView(navController: NavController) {
    Row(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
            .advancedShadow(
                shadowBlurRadius = 10.dp,
                alpha = 0.2f
            )
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = dimensionResource(id = R.dimen.spacer_20)),
        Arrangement.Start,
        Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.navigateUp() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = stringResource(id = R.string.icon_back_description)
            )
        }
        Spacer(Modifier.padding(start = dimensionResource(id = R.dimen.spacer_10)))
        Text(
            text = stringResource(id = R.string.basket),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}