package com.example.fooddelivery.ui.elements

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.R

@Composable
fun AppView() {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.7f)
            .background(MaterialTheme.colorScheme.background)
            .padding(top = dimensionResource(id = R.dimen.spacer_16)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = { }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = stringResource(id = R.string.app_bar_menu_description)
            )
        }
        Icon(
            modifier = Modifier.scale(2.4f),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(id = R.string.app_bar_logo_description),
            tint = MaterialTheme.colorScheme.primary
        )
        IconButton(
            onClick = { }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = stringResource(id = R.string.app_bar_search_description)
            )
        }
    }
}

@Composable
@Preview
fun AppViewPreview() {
    AppView()
}