package com.example.fooddelivery.ui.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.fooddelivery.R

@Composable
fun BasketButton() {
    Button(
        modifier = Modifier.fillMaxWidth(1f),
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.primary
        ),
        shape = MaterialTheme.shapes.extraSmall,
        onClick = { }
    ) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_basket),
                contentDescription = stringResource(id = R.string.button_basket_description)
            )
        }
    }
}