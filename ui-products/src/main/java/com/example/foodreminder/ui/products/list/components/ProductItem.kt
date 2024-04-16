package com.example.foodreminder.ui.products.list.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.foodreminder.ui.common.theme.FoodReminderTheme

@Composable
fun ProductItem(
    name: String,
    quantity: Int,
    modifier: Modifier = Modifier,
    showBottomDivider: Boolean = false,
    backgroundColor: Color = Color.Unspecified,
    contentColor: Color = Color.Unspecified,
) {
    Card(
        modifier = modifier,
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
        ),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = name,
                modifier = Modifier.weight(1f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = quantity.toString())
        }
        if (showBottomDivider) {
            HorizontalDivider()
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewProductItem() {
    FoodReminderTheme {
        ProductItem(
            name = "Product name that is very long just to test how it will look like",
            quantity = 15,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}