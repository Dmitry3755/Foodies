package com.example.fooddelivery.ui.elements

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.domain.entities.Category
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.screens.catalog.view_models.CatalogCategoryViewModel

@Composable
fun CategoriesAppBar(
    configuration: Configuration,
    viewModel: CatalogCategoryViewModel,
    categoriesList: MutableList<Category>
) {

    val lazyListState = rememberLazyListState()

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy((configuration.screenWidthDp.dp * 2) / 100),
        contentPadding = PaddingValues(end = (configuration.screenWidthDp.dp * 3) / 100),
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(top = dimensionResource(id = R.dimen.spacer_8)),
        verticalAlignment = Alignment.CenterVertically,
        state = lazyListState
    ) {
        items(
            count = categoriesList.size
        ) { index ->
            Box(
                modifier = Modifier
                    .height((configuration.screenHeightDp.dp * 5) / 100)
                    .background(
                        color = if (viewModel.selectedCategoryButton.value == categoriesList[index].id) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.background
                        },
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_8))
                    )
                    .clickable(
                        enabled = viewModel.selectedCategoryButton.value != categoriesList[index].id,
                        onClick = {
                            viewModel.selectedCategoryButton.value = categoriesList[index].id
                        },
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    )
                    .padding(horizontal = dimensionResource(id = R.dimen.spacer_10)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = categoriesList[index].name,
                    textAlign = TextAlign.Center,
                    style = if (viewModel.selectedCategoryButton.value == categoriesList[index].id) {
                        MaterialTheme.typography.displayMedium
                    } else {
                        MaterialTheme.typography.displayMedium
                    },
                    color = if (viewModel.selectedCategoryButton.value == categoriesList[index].id) {
                        MaterialTheme.colorScheme.onPrimary
                    } else {
                        MaterialTheme.colorScheme.onPrimaryContainer
                    },
                )
            }
        }
    }
}