package com.example.foodreminder.ui.products.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.foodreminder.ui.common.theme.FoodReminderTheme
import com.example.foodreminder.ui.products.list.components.ProductItem

@Composable
fun ProductListScreen() {
    ProductListScreenContent()
}

@Composable
fun ProductListScreenContent() {
    var isScrollingDown by remember { mutableStateOf(false) }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                when {
                    isScrollingDown && delta > 0 -> isScrollingDown = false
                    !isScrollingDown && delta < 0 -> isScrollingDown = true
                }
                return Offset.Zero
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            AnimatedVisibility(
                visible = !isScrollingDown,
                enter = fadeIn(),
                exit = fadeOut(),
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable { /* todo */ }
                        .background(color = MaterialTheme.colorScheme.primary)
                        .padding(8.dp)
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier.nestedScroll(nestedScrollConnection),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(30) { id ->
                    val productId = id + 1
                    ProductItem(
                        name = "Product number $productId",
                        quantity = 50,
                        showBottomDivider = productId < 30,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { /* todo */ }
                            .padding(top = 16.dp)
                            .padding(horizontal = 16.dp),
                        backgroundColor = Color.Transparent,
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewProductListScreen() {
    FoodReminderTheme {
        ProductListScreenContent()
    }
}