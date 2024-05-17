package com.example.fooddelivery.ui.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.utils.advancedShadow

@Composable
fun BackOutlinedButton(
    navController: NavController
) {
    OutlinedButton(
        onClick = { navController.navigateUp() },
        modifier = Modifier
            .size(50.dp)
            .advancedShadow(
                cornersRadius = 50.dp,
                shadowBlurRadius = 5.dp,
                alpha = 0.1f
            ),
        shape = CircleShape,
        border = BorderStroke(0.dp, Color.Transparent),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Unspecified,
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            tint = Color.Black,
            contentDescription = stringResource(id = R.string.icon_back_description)
        )
    }
}